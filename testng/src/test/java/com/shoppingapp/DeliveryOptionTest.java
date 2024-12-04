import org.testng.Assert;
import org.testng.annotations.Test;
import com.shoppingapp.DeliveryOption;

public class DeliveryOptionTest {

    @Test
    public void testGetOptionName() {
        DeliveryOption option = new DeliveryOption("Standard", 5.0);
        Assert.assertEquals(option.getOptionName(), "Standard", "Option name should be Standard");
    }

    @Test
    public void testGetCost() {
        DeliveryOption option = new DeliveryOption("Standard", 5.0);
        Assert.assertEquals(option.getCost(), 5.0, "Cost should be 5.0");
    }

    @Test
    public void testToString() {
        DeliveryOption option = new DeliveryOption("Standard", 5.0);
        String expected = "Standard - $5.0";
        Assert.assertEquals(option.toString(), expected, "toString method output is incorrect");
    }
}
