import java.util.ArrayList;

public class Conference {
    private int capacity;
    private String name;
    private ArrayList<Guest> guests;

    public Conference(String name, int capacity) {
        this.capacity = capacity;
        this.name = name;
        this.guests = new ArrayList<Guest>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getName() {
        return this.name;
    }

    public int guestCount() {
        return this.guests.size();
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

}
