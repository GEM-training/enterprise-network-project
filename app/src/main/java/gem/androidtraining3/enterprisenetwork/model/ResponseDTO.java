package gem.androidtraining3.enterprisenetwork.model;

/**
 * Created by huylv on 19/02/2016.
 */
public class ResponseDTO {
    int statusCode;
    String message;
    Object returnObject;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    public ResponseDTO(int statusCode, String message, Object returnObject) {

        this.statusCode = statusCode;
        this.message = message;
        this.returnObject = returnObject;
    }
}

