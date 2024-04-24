public class User {
    private String username;
    private int password;

    public User( String username, int password){
        this.username=username;
        this.password=password;
    }
    public String getUsername(){
        return username;

    }
    public void setUsername(){
        this.username=username;
    }
    public int getPassword(){
        return password;
    }
    public void setPassword(){
        this.password=password;
    }

}
