package employeemanagement;

import jakarta.validation.constraints.*;

public class RequestDTO {

    @NotBlank(message = "message cannot be empty/blank")
    @Size(min = 2 , max = 100, message = "A minimum of 2 and maximum of 100 characters required.") 
    private String message;

    @NotBlank(message = "Service type Can't be blank.")
    @Pattern (regexp = "^(sms|email)$", message = "Service type can only be sms or email.", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String serviceType;

    public String getMessage(){
        return message;
    }

    public String getServiceType(){
        return serviceType;
    }

    public void setMessage(String message){
        this.message = message;
    }

     public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }
}
