package employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeemanagementApplication {

	public static void main(String[] args) {
// ApplicationContext represents the spring IoC container. Responsible for instantiating, configuring and assembling beans. 
		ApplicationContext context = SpringApplication.run(EmployeemanagementApplication.class, args);

// Simply calling the getBean() method on the ApplicationContext to retrieve the NotificationService bean. This is how we can access the beans managed by Spring.
		NotificationService service = context.getBean(NotificationService.class);
		service.sendNotification("Welcome to the Employee Management Dashboard.");
	}

}
