package OMP.Controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageDispatcher {

    private final SimpMessagingTemplate template;

    public MessageDispatcher(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void sendToClient(String message, @DestinationVariable String client) {
        this.template.convertAndSend( "/queue/caregiver." + client, message);
    }
}