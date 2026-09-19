package employeemanagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping; // Maps GET requests.
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; // Used to map web requests onto specific handler classes and/or handler methods.
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController  
@RequestMapping ("/api/employee") // Provides base url
public class NotificationController {

//   private final List<String> employees = new ArrayList<>(List.of("Victor Mutinda","Annette Mutuku","Santa Rafiki"));

    private final NotificationService notificationService; 

    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @PostMapping("/notify") // Maps POST requests to sendNotification() method. This method is called when a POST request is made to the /api/employee/notify endpoint.
    
    public ResponseEntity<String> sendAlert(@Valid @RequestBody RequestDTO request) {
// ResponseEntity - a built in Springboot framework class that represents entire HTTP response
// It gives you full control over what goes back to the client, allowing you to configure:
//  1. HTTP Status Code (200 OK, 201 CREATED, 400 BAD_REQUEST, 401 NOT_FOUND), 2. HTTP Headers , 3. HTTP Response Body
        String message = request.getMessage();
        String serviceType = request.getServiceType();
// Instead of creating message & serviceType variables. We could pass the above get Methods() as
// parameters in the notificationService.sendNotification() method just to make it shorter


        //notificationService.sendNotification(message,serviceType);

        if (notificationService.sendNotification(message, serviceType)) { // if true, then notification was sent
          return ResponseEntity.ok("Notification sent successfully"); // http status code of 200 OK
        } else { // if false, choose between sms or email to send a notification successfully.
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose between email or sms");
           // http status code of 400 BAD REQUEST
        }
    }

   /* @PostMapping
    public String sendAlert(@ResponseBody String message, String serviceType){
        if (notificationService.sendNotification(message, serviceType)) { // if true, then notification was sent
           return "Notification sent successfully.";
        } else { // if false, choose between sms or email to send a notification successfully.
           return "Choose between sms or email";
        }
    }

     */      //  return "Notification sent successfully.";
    

    
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



