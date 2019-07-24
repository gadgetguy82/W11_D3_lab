import org.junit.Before;
import org.junit.Test;

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

        this.bedroom1 = new Bedroom(101, 2, "double");
        this.bedroom2 = new Bedroom(102, 1, "single");
        this.bedroom3 = new Bedroom(103, 3, "king");
        this.bedroom4 = new Bedroom(104, 1, "single");
        this.bedroom5 = new Bedroom(105, 2, "double");

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
}
