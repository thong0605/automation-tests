import org.testng.Assert;
import org.testng.annotations.Test;
import com.shoppingapp.Product;
import com.shoppingapp.ProductService;

public class ProductServiceTest {

    @Test
    public void testAddProduct() {
        ProductService productService = new ProductService();
        Product product = new Product("Laptop", 1200, 10);
        productService.addProduct(product);
        Assert.assertNotNull(productService.getProductById("Laptop"), "Product should be added and retrievable");
    }

    @Test
    public void testUpdateProduct() {
        ProductService productService = new ProductService();
        Product product = new Product("Laptop", 1200, 10);
        productService.addProduct(product);
        product.setPrice(1300);
        productService.updateProduct(product);
        Assert.assertEquals(productService.getProductById("Laptop").getPrice(), 1300, "Product price should be updated");
    }
}
