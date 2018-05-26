package se.cygni.boklan;

public class Reservation {
    String id;
    boolean reserve;
    String name;

    public Reservation() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isReserve() {
        return reserve;
    }
}
