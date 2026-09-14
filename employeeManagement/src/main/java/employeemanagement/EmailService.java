package employeemanagement;

import org.springframework.stereotype.Component;

@Component("email") //This tells Spring to create Spring bean with name "email" for this class
public class EmailService implements MessageService {

@Override
    public void sendMessage(String message){
        System.out.println("Email sent : " + message);
    }

} 