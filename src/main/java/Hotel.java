import java.util.ArrayList;

public class Hotel {
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<Conference> conferenceRooms;

    public Hotel() {
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<Conference>();
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

    public Bedroom getBedroom(int roomNumber) {
        for (Bedroom room:this.bedrooms){
            if (room.getRoomNumber() == roomNumber)
                return room;
        }
        return null;
    }

    public void checkIn(int roomNumber, Guest guest) {
        getBedroom(roomNumber).addGuest(guest);
    }

    public void checkOut(int roomNumber, Guest guest){
        getBedroom(roomNumber).removeGuest(guest);
    }
}
