package se.cygni.boklan;

public class Reservation {
    String id;
    boolean unReserve;
    String name;

    public Reservation() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isUnReserve() {
        return unReserve;
    }
}
