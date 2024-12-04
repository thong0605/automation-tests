import org.testng.Assert;
import org.testng.annotations.Test;
import com.shoppingapp.CartService;
import com.shoppingapp.Cart;

public class CartServiceTest {

    @Test
    public void testCreateCart() {
        CartService cartService = new CartService();
        Cart cart = cartService.createCart("user1");
        Assert.assertNotNull(cart, "Cart should be created for user");
    }

    @Test
    public void testGetCart() {
        CartService cartService = new CartService();
        cartService.createCart("user1");
        Assert.assertNotNull(cartService.getCart("user1"), "Cart should be retrieved for user");
    }

    @Test
    public void testCheckoutCart() {
        CartService cartService = new CartService();
        cartService.createCart("user1");
        cartService.checkoutCart("user1");
        Assert.assertNull(cartService.getCart("user1"), "Cart should be removed after checkout");
    }
}
