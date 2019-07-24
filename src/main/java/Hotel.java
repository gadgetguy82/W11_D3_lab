import java.util.ArrayList;

public class Hotel {
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<Conference> conferenceRooms;
    private ArrayList<Booking> bookings;

    public Hotel() {
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public int bedroomCount() {
        return this.bedrooms.size();
    }

    public int conferenceRoomCount() {
        return this.conferenceRooms.size();
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void addConference(Conference conference) {
        this.conferenceRooms.add(conference);
    }

    public Bedroom getBedroom(Integer roomNumber) {
        for (Bedroom room:this.bedrooms){
            if (room.getRoomNumber() == roomNumber)
                return room;
        }
        return null;
    }

    public Conference getConference(String roomName) {
        for (Conference room:this.conferenceRooms){
            if (room.getName() == roomName)
                return room;
        }
        return null;
    }

    public Booking getBooking(Bedroom bedroom) {
        for (Booking booking:this.bookings){
            if (booking.getBedroom() == bedroom) {
                return booking;
            }
        }
        return null;
    }

    public void checkIn(int roomNumber, Guest guest) {
        if (getBedroom(roomNumber).guestCount() == 0) {
            getBedroom(roomNumber).addGuest(guest);
        }
    }

    public void checkOut(int roomNumber, Guest guest){
        getBedroom(roomNumber).removeGuest(guest);
    }

    public void checkIn(String roomName, Guest guest) {
        getConference(roomName).addGuest(guest);
    }

    public void checkOut(String roomName, Guest guest){
        getConference(roomName).removeGuest(guest);
    }

    public Booking bookRoom(Bedroom bedroom, int nightsBooked) {
        Booking booking = new Booking(bedroom, nightsBooked);
        return booking;
    }

    public ArrayList<Bedroom> getEmptyBedrooms() {
        ArrayList<Bedroom> emptyRooms = new ArrayList<>();
        for (Bedroom room : this.bedrooms) {
            if (room .guestCount() == 0) {
                emptyRooms.add(room);
            }
        }
        return emptyRooms;
    }
}
