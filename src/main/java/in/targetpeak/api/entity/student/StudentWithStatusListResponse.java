package in.targetpeak.api.entity.student;


import java.util.ArrayList;
import java.util.List;

public class StudentWithStatusListResponse {

    String AuthorizationToken;
    int Result;
    String Message;
    int HasError;
    List<StudentWithStatusHolder> ResponseArray;

    public String getAuthorizationToken() {
        return AuthorizationToken;
    }

    public void setAuthorizationToken(String authorizationToken) {
        AuthorizationToken = authorizationToken;
    }

    public int getResult() {
        return Result;
    }

    public void setResult(int result) {
        Result = result;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getHasError() {
        return HasError;
    }

    public void setHasError(int hasError) {
        HasError = hasError;
    }

    public List<StudentWithStatusHolder> getResponseArray() {
        return ResponseArray;
    }

    public void setResponseArray(List<StudentWithStatusHolder> responseArray) {
        ResponseArray = responseArray;
    }

    @Override
    public String toString() {
        return "StudentListResponse{" +
                "AuthorizationToken='" + AuthorizationToken + '\'' +
                ", Result=" + Result +
                ", Message='" + Message + '\'' +
                ", HasError=" + HasError +
                ", ResponseArray=" + ResponseArray +
                '}';
    }
}
