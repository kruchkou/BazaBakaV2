package entity;

public class StringUser {
    private String name;
    private String android_id;

    public StringUser(String name, String android_id) {
        this.name = name;
        this.android_id = android_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAndroid_id() {
        return android_id;
    }

    public void setAndroid_id(String android_id) {
        this.android_id = android_id;
    }
}
