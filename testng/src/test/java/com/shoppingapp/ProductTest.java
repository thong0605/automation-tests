import org.testng.Assert;
import org.testng.annotations.Test;
import com.shoppingapp.Product;

public class ProductTest {

    @Test
    public void testRestock() {
        Product product = new Product("Laptop", 1200, 10);
        product.restock(5);
        Assert.assertEquals(product.getStock(), 15, "Stock should increase after restocking");
    }

    @Test
    public void testIsInStock() {
        Product product = new Product("Laptop", 1200, 0);
        Assert.assertFalse(product.isInStock(), "Product should not be in stock");
        product.restock(10);
        Assert.assertTrue(product.isInStock(), "Product should be in stock after restocking");
    }

    @Test
    public void testGetPrice() {
        Product product = new Product("Laptop", 1200, 10);
        Assert.assertEquals(product.getPrice(), 1200, "Price should be 1200");
    }
}
