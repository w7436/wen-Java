package nancy.pojo;

/**
 * @ClassName User
 * @Description TODO
 * @Author DELL
 * @Data 2020/9/10 15:34
 * @Version 1.0
 **/
public class User {
    private int id;
    private String name;
    private String password;
    public User(){

    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
