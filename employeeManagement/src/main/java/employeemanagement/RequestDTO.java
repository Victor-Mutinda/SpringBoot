package employeemanagement;

public class RequestDTO {
    private String message;
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
