package T02_ExtendDatabase;

public class People {
    private int Id;
    private String Username;

    public People(int id, String username) {
        this.Id = id;
        this.Username = username;
    }

    public int getId() {
        return Id;
    }
    public String getUsername() {
        return Username;
    }
}
