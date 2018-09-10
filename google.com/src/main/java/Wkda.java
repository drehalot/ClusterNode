public class Wkda {
    private String msg;

    public String getKey1() {
        return "Value1" + msg;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return "Value2" + msg;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return "Value3" + msg;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    private String key1;
    private String key2;
    private String key3;

    public Wkda(String key) {
        this.msg = key;
    }

}
