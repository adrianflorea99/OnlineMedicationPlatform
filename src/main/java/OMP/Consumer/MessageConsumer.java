package OMP.Consumer;

import OMP.Controller.MessageDispatcher;
import OMP.Entity.Activity;
import OMP.Entity.Patient;
import OMP.Producer.SensorActivity;
import OMP.Repository.ActivityRepository;
import OMP.Repository.PatientRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.TimeoutException;

@Component
public class MessageConsumer {

    private final ActivityRepository activityRepository;
    private final PatientRepository patientRepository;
    private final MessageDispatcher messageDispatcher;

    @Autowired
    public MessageConsumer(ActivityRepository activityRepository, PatientRepository patientRepository,
                           MessageDispatcher messageDispatcher) {
        this.activityRepository = activityRepository;
        this.patientRepository = patientRepository;
        this.messageDispatcher = messageDispatcher;
    }

    public void readMessagesFromQueue() throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        //factory.setUsername("admin");
        //factory.setPassword("admin");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException | TimeoutException ioException) {
            ioException.printStackTrace();
        }
        Channel channel = null;
        try {
            channel = connection.createChannel();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            channel.queueDeclare("activities", false, false, false, null);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        channel.basicConsume("activities", true, (consumerTag, message) -> {
            String m = new String(message.getBody(), "UTF-8");
            SensorActivity sensorActivity = new SensorActivity();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode messageNode = objectMapper.readTree(m);
            sensorActivity.setUsername(messageNode.get("patient_id").asText());
            sensorActivity.setActivity(messageNode.get("activity").asText());
            sensorActivity.setStart(messageNode.get("start").asLong());
            sensorActivity.setEnd(messageNode.get("end").asLong());
            Patient patient = getPatient(sensorActivity.getUsername());
            addActivity(sensorActivity, patient);

            long difference = 0;
            difference = getDifferenceStartEnd(sensorActivity);

            if (isAnomaly(sensorActivity, difference)) {
                if (sleepLongerThan7Hours(sensorActivity, difference))
                {
                    messageDispatcher.sendToClient("Anomaly found: R1", "Elena.Balog@gmail.com");
                }
                else {
                    if (leavingLongerThan5Hours(sensorActivity, difference)) {
                        messageDispatcher.sendToClient("Anomaly found: R2", "Elena.Balog@gmail.com");
                    }
                    else {
                        messageDispatcher.sendToClient("Anomaly found: R3", "Elena.Balog@gmail.com");
                    }
                }
            }

            System.out.println("Message: " + m + " received!");
        }, consumerTag -> {
        });
    }

    private void addActivity(SensorActivity sensorActivity, Patient patient) {
        Activity activity = new Activity();
        activity.setName(sensorActivity.getActivity());
        activity.setStart_time(BigInteger.valueOf(sensorActivity.getStart()));
        activity.setEnd_time(BigInteger.valueOf(sensorActivity.getEnd()));
        activityRepository.saveAndFlush(activity);
        activity.getMadeByPatients().add(patient);
        patient.getDoingActivities().add(activity);
        patientRepository.save(patient);
    }

    private Patient getPatient(String username) {
        return patientRepository.findPatientByNameFetchActivities(username);
    }

    private boolean isAnomaly(SensorActivity sensorActivity, long difference) {
        if (sleepLongerThan7Hours(sensorActivity, difference) || leavingLongerThan5Hours(sensorActivity, difference) ||
                bathroomLongerThan5Hours(sensorActivity, difference)) {
            System.out.println("Anomaly: " + sensorActivity.toString());
            return true;
        }
        return false;
    }

    private boolean sleepLongerThan7Hours(SensorActivity sensorActivity, long difference) {
        return sensorActivity.getActivity().equals("Sleeping") && difference > (7 * 60 * 60 * 1000);
    }

    private boolean leavingLongerThan5Hours(SensorActivity sensorActivity, long difference) {
        return sensorActivity.getActivity().equals("Leaving") && difference > (5 * 60 * 60 * 1000);
    }

    private boolean bathroomLongerThan5Hours(SensorActivity sensorActivity, long difference) {
        return (sensorActivity.getActivity().equals("Showering") || sensorActivity.getActivity().equals("Toileting")) && difference > (30 * 60 * 1000);
    }

    private long getDifferenceStartEnd(SensorActivity sensorActivity) {
        return sensorActivity.getEnd() - sensorActivity.getStart();
    }
}
