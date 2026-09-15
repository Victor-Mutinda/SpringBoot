package employeemanagement;

import org.springframework.web.bind.annotation.GetMapping; // Maps GET requests.
import org.springframework.web.bind.annotation.RequestMapping; // Used to map web requests onto specific handler classes and/or handler methods.
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 
//import java.util.* ;

@RestController 
@RequestMapping ("/api/employee") // Provides base url
public class NotificationController {

//   private final List<String> employees = new ArrayList<>(List.of("Victor Mutinda","Annette Mutuku","Santa Rafiki"));

    private final NotificationService notificationService; 

    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @GetMapping("/notify") // Maps GET requests to getNotification() method. This method is called when a GET request is made to the /api/employee endpoint.
    public String getNotification(@RequestParam  String message, @RequestParam String serviceType){


        notificationService.sendNotification(message,serviceType);

        if (notificationService.isInValidService == false) {
            return "Notification sent successfully.";
        } else {
            return "Choose between sms or email";
        }
        
      //  return "Notification sent successfully.";
    }


    
    /* @GetMapping
    public List<String> getAllEmployees(){ // This methods returns all employees 
        return employees;
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable int id){
         // Method returns employee by id.
         // PathVariable annotation used to extract value from the url path.
        if(id >= 0 && id < employees.size()){

            return employees.get(id);
        }

        return "Employee not found";

    }

    @PostMapping 
    public String addEmployee(@RequestBody String employee){
        // RequestBody annotation used to bind the incoming request body to the method parameter.
        // This method adds a new employee to the list.
        employees.add(employee);
        return "Employee added successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id){

        if ( id >= 0 && id < employees.size()){

            employees.remove(id);
            return "Employee deleted successfully";
        }
        return "Employee not found";


    }
*/

}
