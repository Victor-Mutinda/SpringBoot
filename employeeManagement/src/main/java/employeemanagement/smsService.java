package employeemanagement;
import org.springframework.stereotype.Component;

@Component ("sms") //This tells Spring to create Spring bean with name "sms" for this class
public class smsService implements MessageService {
    @Override 
    public void sendMessage(String message){
        System.out.println("SMS sent : " + message);
    }
    
}
