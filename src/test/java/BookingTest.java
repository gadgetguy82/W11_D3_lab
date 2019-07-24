import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {
  private Booking booking;
  private Bedroom bedroom;

  @Before
  public void setUp() {
    bedroom = new Bedroom(102, 2, "double", 15.00);
    booking = new Booking(bedroom, 3);
  }

  @Test
  public void hasBedroom() {
    assertEquals(bedroom, booking.getBedroom());
  }

  @Test
  public void canGetNightsBooked() {
    assertEquals(3, booking.getNightsBooked());
  }

  @Test
  public void hasTotalBill() {
    assertEquals(45.00, booking.getTotal(), 0.01);
  }
}
