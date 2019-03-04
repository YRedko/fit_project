package project.exeptions;

public class UserAlreadyExsists extends RuntimeException {

    private String login;

    public UserAlreadyExsists(String login){
        this.login = login;
    }
}
