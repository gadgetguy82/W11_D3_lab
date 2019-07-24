import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    private Guest guest;


    @Before
    public void setUp(){
        guest = new Guest("Bob");
    }

    @Test
    public void hasName(){
        assertEquals("Bob", guest.getName());
    }
}
