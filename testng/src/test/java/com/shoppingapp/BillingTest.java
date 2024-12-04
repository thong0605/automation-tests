import org.testng.Assert;
import org.testng.annotations.Test;
import com.shoppingapp.Billing;

public class BillingTest {

    @Test
    public void testCalculateFinalAmount() {
        Billing billing = new Billing();
        billing.setTotalAmount(100);
        billing.applyDiscount(10);
        double expected = 90;
        Assert.assertEquals(billing.calculateFinalAmount(), expected, "Final amount after discount is incorrect");
    }

    @Test
    public void testValidatePayment() {
        Billing billing = new Billing();
        Assert.assertTrue(billing.validatePayment("1234567812345678"), "Payment validation should succeed for valid card number");
        Assert.assertFalse(billing.validatePayment("1234"), "Payment validation should fail for invalid card number");
    }
}
