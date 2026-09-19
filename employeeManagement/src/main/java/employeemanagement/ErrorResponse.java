package employeemanagement;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private Map<String, String> validations; // Holds field names and error messages

    public ErrorResponse (int status, String error, String message,Map<String, String> validations){
        this.timestamp = LocalDateTime.now();
        this.status =  status;
        this.error = error;
        this.message = message;
        this.validations = validations;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getValidations() {
        return validations;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setValidations(Map<String, String> validations) {
        this.validations = validations;
    }

}
