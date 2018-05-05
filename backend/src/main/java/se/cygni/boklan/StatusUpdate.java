package se.cygni.boklan;

public class StatusUpdate {
    String id;
    Boolean available;

    public StatusUpdate() {

    }

    public StatusUpdate(String id, boolean available) {
        this.id = id;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public Boolean getAvailable() {
        return available;
    }
}
