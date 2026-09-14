package employeemanagement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final MessageService messageService;

    public NotificationService(@Qualifier("email") MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendNotification(String message){
        messageService.sendMessage(message);
    }

    
}
