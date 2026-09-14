package employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeemanagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeemanagementApplication.class, args);

		NotificationService service = context.getBean(NotificationService.class);
		service.sendNotification("Welcome to the Employee Management Dashboard");
	}

}
