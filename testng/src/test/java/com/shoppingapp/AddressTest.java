import org.testng.Assert;
import org.testng.annotations.Test;
import com.shoppingapp.Address;

public class AddressTest {

    @Test
    public void testGetFullAddress() {
        Address address = new Address("123 Main St", "Anytown", "CA", "90210");
        String expected = "123 Main St, Anytown, CA 90210";
        Assert.assertEquals(address.getFullAddress(), expected, "Full address is incorrect");
    }

    @Test
    public void testAddressEquality() {
        Address address1 = new Address("123 Main St", "Anytown", "CA", "90210");
        Address address2 = new Address("123 Main St", "Anytown", "CA", "90210");
        Assert.assertEquals(address1, address2, "Addresses should be equal");
    }

    @Test
    public void testAddressInequality() {
        Address address1 = new Address("123 Main St", "Anytown", "CA", "90210");
        Address address2 = new Address("456 Elm St", "Othertown", "TX", "75001");
        Assert.assertNotEquals(address1, address2, "Addresses should not be equal");
    }
}
