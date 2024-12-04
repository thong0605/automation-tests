import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
import com.shoppingapp.Address;
import com.shoppingapp.Delivery;

public class DeliveryTest {

    @Test
    public void testSetDeliveryAddress() {
        Delivery delivery = new Delivery();
        Address address = new Address("123 Main St", "Anytown", "CA", "90210");
        delivery.setDeliveryAddress(address);
        Assert.assertEquals(delivery.getDeliveryAddress(), address, "Delivery address should be set correctly");
    }

    @Test
    public void testSetDeliveryDate() {
        Delivery delivery = new Delivery();
        LocalDateTime date = LocalDateTime.now();
        delivery.setDeliveryDate(date);
        Assert.assertEquals(delivery.getDeliveryDate(), date, "Delivery date should be set correctly");
    }

    @Test
    public void testGetDeliveryDetails() {
        Delivery delivery = new Delivery();
        Address address = new Address("123 Main St", "Anytown", "CA", "90210");
        LocalDateTime date = LocalDateTime.now();
        delivery.setDeliveryAddress(address);
        delivery.setDeliveryDate(date);
        String expected = "Delivery to: 123 Main St, Anytown, CA 90210 on " + date;
        Assert.assertEquals(delivery.getDeliveryDetails(), expected, "Delivery details should be correct");
    }
}
