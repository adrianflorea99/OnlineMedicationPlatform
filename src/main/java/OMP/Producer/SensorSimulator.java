package OMP.Producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Producer
 */
public class SensorSimulator {

    public static void main(String[] args) {
        sendMessagesToQueue();
    }

    static void sendMessagesToQueue() {
        List<String> messages = readActivitiesFromFile();

        ConnectionFactory factory = new ConnectionFactory();
        //factory.setUsername("admin"); // Docker Desktop
        //factory.setPassword("admin"); // Docker Desktop
        factory.setUsername("guest"); // RabbitMQ Server local
        factory.setPassword("guest"); // RabbitMQ Server local
        //factory.setUsername("vmefamvz"); // CloudAM QP
        //factory.setPassword("YQfoT4dbmHJZW0RKPLLdCvSXPnCUJlQn"); // CloudAMQP
        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.queueDeclare("activities", false, false, false, null);

            for (String message : messages) {
                channel.basicPublish("", "activities", false, null, message.getBytes());
                System.out.println("Message: " + message + " sent!");
//                Thread.sleep(1000);
            }

        } catch (TimeoutException | IOException e) {
            e.printStackTrace();
        }
    }

    static List<String> readActivitiesFromFile() {
        List<String> messages = new ArrayList<>();
        try {
            // open file to read
            Scanner scanner = new Scanner(new File("activity.txt"));

            // read until end of file (EOF)
            while (scanner.hasNextLine()) {
                String S = scanner.nextLine();
                String[] animals = S.split("\\s+");

                String start_time_string = animals[0] + " " + animals[1];
                String end_time_string = animals[2] + " " + animals[3];
                String activity = animals[4];

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = sdf.parse(start_time_string);
                long start_time = date.getTime();
                date = sdf.parse(end_time_string);
                long end_time = date.getTime();

                messages.add(new SensorActivity("acflorea99@gmail.com", activity, start_time, end_time).toString());
//                System.out.println(new SensorActivity("acflorea99@gmail.com", activity, start_time, end_time).toString());
            }

            // close the scanner
            scanner.close();

        } catch (FileNotFoundException | ParseException ex) {
            ex.printStackTrace();
        }
        return messages;
    }
}
