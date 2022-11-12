import java.util.Random;

public class URL {
    private int uniqueID;
    private String url;
    private int count;

    public URL() {
        Random random=new Random();
        uniqueID=random.nextInt(99999);
        count=0;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "URL{" +
                "uniqueID=" + uniqueID +
                ", url='" + url +
                ", count=" + count +
                '}'+"\n";
    }
}
