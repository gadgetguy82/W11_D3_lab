import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {
    private Bedroom bedroom;
    private Guest guest;

    @Before
    public void setUp() {
        bedroom = new Bedroom(101,  2, "double");
        guest = new Guest("Bob");
    }

    @Test
    public void hasRoomNumber(){
        assertEquals(new Integer(101), bedroom.getRoomNumber());
    }

    @Test
    public void hasCapacity(){
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void hasType(){
        assertEquals("double", bedroom.getType());
    }

    @Test
    public void startsWithNoGuests(){
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void canAddGuestToBedroom(){
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.guestCount());
    }
}
