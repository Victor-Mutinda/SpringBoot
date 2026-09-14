package employeemanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //Special type of component. Used to handle business logic. It is used to mark the class as a service provider.
public class NotificationService {

    private final MessageService messageService; // loose coupling
@Autowired  //This tells Spring to inject the dependency of MessageService into this class. It is used to mark a constructor, field, or method as a candidate for autowiring.
    public NotificationService(@Qualifier("sms") MessageService messageService) { 
// constructor injection above. This tells Spring to inject the dependency of MessageService into this class.
        this.messageService = messageService;
    }

    public void sendNotification(String message){
        messageService.sendMessage(message);
    }

    
}
