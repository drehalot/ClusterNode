
public class Greeting {

    private final long id;

    private boolean isRead;

    private final String content;

    public Greeting() {
        this.id = -1;
        this.content = "";
    }

    public Greeting(long id, String content, boolean isRead) {
        this.id = id;
        this.content = content;
        this.isRead = isRead;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}