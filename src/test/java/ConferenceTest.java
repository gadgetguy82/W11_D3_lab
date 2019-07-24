import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceTest {
    private Conference conference;
    private Guest guest;

    @Before
    public void setUp(){
        conference = new Conference("Edinburgh Suite", 500);
        guest = new Guest("Bob");
    }

    @Test
    public void hasName(){
        assertEquals("Edinburgh Suite", conference.getName());
    }

    @Test
    public void hasCapacity(){
        assertEquals(500, conference.getCapacity());
    }

    @Test
    public void startWithNoGuests() {
        assertEquals(0, conference.guestCount());
    }
    
    @Test
    public void canAddGuestToConference(){
        conference.addGuest(guest);
        assertEquals(1, conference.guestCount());
    }
    
}
