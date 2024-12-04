import org.testng.Assert;
import org.testng.annotations.Test;
import com.shoppingapp.DeliveryOption;
import com.shoppingapp.DeliveryService;

public class DeliveryServiceTest {

    @Test
    public void testAddDeliveryOption() {
        DeliveryService service = new DeliveryService();
        DeliveryOption option = new DeliveryOption("Standard", 5.0);
        service.addDeliveryOption(option);
        Assert.assertTrue(service.getAvailableOptions().contains(option), "Option should be added to the delivery options");
    }

    @Test
    public void testGetAvailableOptions() {
        DeliveryService service = new DeliveryService();
        Assert.assertNotNull(service.getAvailableOptions(), "Delivery options should be retrieved");
    }
}
