import java.util.ArrayList;

public class Bedroom {
    private Integer roomNumber;
    private int capacity;
    private String type;
    private ArrayList<Guest> guests;
    private double rate;

    public Bedroom(Integer roomNumber, int capacity, String type, double rate){
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.type = type;
        this.guests = new ArrayList<Guest>();
        this.rate = rate;
    }

    public Integer getRoomNumber() {
        return this.roomNumber;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getType() {
        return this.type;
    }

    public double getRate() {
        return this.rate;
    }

    public int guestCount() {
        return this.guests.size();
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public void removeGuest(Guest guest) {
        this.guests.remove(guest);
    }
}
