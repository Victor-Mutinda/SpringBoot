package employeemanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //Special type of component. Used to handle business logic. It is used to mark the class as a service provider.
public class NotificationService {

  //  private final MessageService messageService; // loose coupling

//@Autowired  //It is used to mark a constructor, field, or method as a candidate for autowiring.
  /*  public NotificationService(@Qualifier("sms") MessageService messageService) { 
// Constructor injection above. This tells Spring to inject the dependency of MessageService into this class. That is smsService class.
        this.messageService = messageService;
    }

    public void sendNotification(String message){
        messageService.sendMessage(message);
    }
    */
    private final SmsService smsService;
    private final EmailService emailService;

    @Autowired 
    public NotificationService(SmsService smsService, EmailService emailService){
        this.smsService = smsService;
        this.emailService = emailService;
    }

   // boolean isInValidService;

    public boolean sendNotification(String message, String serviceType){
        if(serviceType.equalsIgnoreCase("sms")){
            smsService.sendMessage(message);
            //isInValidService = false;
            return true;
        } else if(serviceType.equalsIgnoreCase("email")){
            emailService.sendMessage(message);
            //isInValidService = false;
            return true;
        }
        else {
           System.out.println("Invalid service type. Choose between sms or email.");
           return false;

        }
    }
    
}
