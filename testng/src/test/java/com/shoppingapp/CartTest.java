import org.testng.Assert;
import org.testng.annotations.Test;
import com.shoppingapp.Cart;
import com.shoppingapp.Product;

public class CartTest {

    @Test
    public void testAddItem() {
        Cart cart = new Cart();
        Product product = new Product("Laptop", 1200, 10);
        cart.addItem(product);
        Assert.assertEquals(cart.getItems().size(), 1, "Cart should have 1 item");
    }

    @Test
    public void testRemoveItem() {
        Cart cart = new Cart();
        Product product = new Product("Laptop", 1200, 10);
        cart.addItem(product);
        cart.removeItem(product);
        Assert.assertTrue(cart.isEmpty(), "Cart should be empty after item removal");
    }

    @Test
    public void testGetTotalPrice() {
        Cart cart = new Cart();
        cart.addItem(new Product("Laptop", 1200, 10));
        cart.addItem(new Product("Mouse", 20, 50));
        Assert.assertEquals(cart.getTotalPrice(), 1220.0, "Total price is incorrect");
    }
}
