package employeemanagement;

import java.time.LocalDateTime;
import java.util.Map;

// This call is Responsible for the Error is structured. The attributes.
public class ErrorResponse {
    private LocalDateTime timestamp; // Indicates when the error occurred
    private int status; // Indicates the http status code
    private String error; // Indicates the short/general description of http error. Eg Bad_Request
    private String message; // Indicates the explanation of what went wrong
    private Map<String, String> validations; // Holds field names and error messages. This contains the specific field-level errors.

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
