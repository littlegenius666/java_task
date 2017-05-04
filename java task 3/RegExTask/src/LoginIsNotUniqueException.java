/**
 * Created by uzer on 02.05.2017.
 */
public class LoginIsNotUniqueException extends Exception{
    private String message;

    public LoginIsNotUniqueException(){
        this.message = "Nickname must be unique!";
    }

    public LoginIsNotUniqueException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }

}
