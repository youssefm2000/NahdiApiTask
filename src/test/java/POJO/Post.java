package POJO;

public class Post {

    // Fields representing the attributes of a post
    private String title;
    private String body;
    private int userId;

    /**
     * Constructor to initialize all fields of the Post object.
     *
     * @param title  The title of the post
     * @param body   The content/body of the post
     * @param userId The ID of the user creating the post
     */
    public Post(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    // Getter and setter for 'title'
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    // Getter and setter for 'body'
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    // Getter and setter for 'userId'
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}
