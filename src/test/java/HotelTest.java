import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    private Hotel hotel;
    private Guest guest;

    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private Bedroom bedroom3;
    private Bedroom bedroom4;
    private Bedroom bedroom5;

    private Conference conference1;
    private Conference conference2;

    @Before
    public void setUp() {
        hotel = new Hotel();
        guest = new Guest("Bob");

        this.bedroom1 = new Bedroom(101, 2, "double", 13.00);
        this.bedroom2 = new Bedroom(102, 1, "single", 10.00);
        this.bedroom3 = new Bedroom(103, 3, "king", 20.99);
        this.bedroom4 = new Bedroom(104, 1, "single", 11.00);
        this.bedroom5 = new Bedroom(105, 2, "double", 15.49);

        hotel.addBedroom(bedroom1);
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom3);
        hotel.addBedroom(bedroom4);
        hotel.addBedroom(bedroom5);

        this.conference1 = new Conference("Edinburgh", 500);
        this.conference2 = new Conference("Stirling", 50);

        hotel.addConference(conference1);
        hotel.addConference(conference2);
    }

    @Test
    public void startsWith5Bedrooms() {
        assertEquals(5, hotel.bedroomCount());
    }

    @Test
    public void startsWith2Conference() {
        assertEquals(2, hotel.conferenceRoomCount());
    }

    @Test
    public void canGetBedroom(){
        assertEquals(this.bedroom1, hotel.getBedroom(101));
    }

    @Test
    public void canCheckIn(){
        hotel.checkIn(101, guest);
        assertEquals(1, hotel.getBedroom(101).guestCount());
    }

    @Test
    public void canCheckOut(){
        hotel.checkIn(101, guest);
        assertEquals(1, hotel.getBedroom(101).guestCount());
        hotel.checkOut(101, guest);
        assertEquals(0, hotel.getBedroom(101).guestCount());
    }

    @Test
    public void canCheckInConference() {
        hotel.checkIn("Edinburgh", guest);
        assertEquals(1, hotel.getConference("Edinburgh").guestCount());
    }

    @Test
    public void canCheckOutConference() {
        hotel.checkIn("Edinburgh", guest);
        assertEquals(1, hotel.getConference("Edinburgh").guestCount());
        hotel.checkOut("Edinburgh", guest);
        assertEquals(0, hotel.getConference("Edinburgh").guestCount());
    }

    @Test
    public void canBookRoom() {
        Booking booking = hotel.bookRoom(this.bedroom2, 3);
//        assertEquals(booking, hotel.getBooking(this.bedroom2));
        assertEquals(this.bedroom2, booking.getBedroom());
        assertEquals(3, booking.getNightsBooked());
    }

    @Test
    public void canReturnAllEmptyRooms() {
        hotel.checkIn(103, guest);
        hotel.checkIn(105, guest);
        ArrayList<Bedroom> emptyRooms = new ArrayList<Bedroom>();
        emptyRooms.add(this.bedroom1);
        emptyRooms.add(this.bedroom2);
        emptyRooms.add(this.bedroom4);
        assertEquals(emptyRooms, hotel.getEmptyBedrooms());
    }

    @Test
    public void cannotCheckGuestsIntoRoomsWithGuests() {
        hotel.checkIn(103, guest);
        hotel.checkIn(103, guest);
        assertEquals(1, hotel.getBedroom(103).guestCount());
    }
}
