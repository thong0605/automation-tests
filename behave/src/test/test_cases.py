import unittest
from src.main.shoppingapp.address import Address
from src.main.shoppingapp.billing import Billing
from src.main.shoppingapp.cart import Cart
from src.main.shoppingapp.cart_service import CartService
from src.main.shoppingapp.delivery import Delivery
from src.main.shoppingapp.delivery_option import DeliveryOption
from src.main.shoppingapp.delivery_service import DeliveryService
from src.main.shoppingapp.product import Product
from src.main.shoppingapp.product_service import ProductService

class TestShoppingApp(unittest.TestCase):

    def test_address(self):
        addr = Address("123 Main St", "Cityville", "CA", "90001")
        self.assertEqual(addr.get_full_address(), "123 Main St, Cityville, CA 90001")

    def test_billing(self):
        bill = Billing()
        bill.set_total_amount(100)
        bill.apply_discount(10)
        self.assertEqual(bill.calculate_final_amount(), 90)

        # Test for 100% discount
        bill.apply_discount(100)
        self.assertEqual(bill.calculate_final_amount(), 0)

        # Test for no discount
        bill.apply_discount(0)
        self.assertEqual(bill.calculate_final_amount(), 100)

    def test_cart(self):
        cart = Cart()
        prod1 = Product("Laptop", 1000, 5)
        prod2 = Product("Phone", 500, 10)
        cart.add_item(prod1)
        cart.add_item(prod2)
        self.assertEqual(cart.get_total_price(), 1500)

        # Test cart remove item
        cart.remove_item(prod1)
        self.assertEqual(cart.get_total_price(), 500)

        cart.clear_cart()
        self.assertTrue(cart.is_empty())

    def test_cart_service(self):
        cart_service = CartService()
        user_id = "user123"
        cart = cart_service.create_cart(user_id)
        self.assertIsNotNone(cart_service.get_cart(user_id))

        # Add items and checkout
        prod1 = Product("Laptop", 1000, 5)
        cart.add_item(prod1)
        cart_service.checkout_cart(user_id)
        self.assertIsNone(cart_service.get_cart(user_id))

    def test_delivery(self):
        delivery = Delivery()
        addr = Address("123 Main St", "Sanfrancisco", "CA", "90001")
        delivery.set_delivery_address(addr)
        delivery.set_delivery_date("2024-12-25")
        self.assertIn("123 Main St", delivery.get_delivery_details())
        self.assertIn("2024-12-25", delivery.get_delivery_details())

    def test_delivery_option(self):
        option = DeliveryOption("Express", 25.0)
        self.assertEqual(str(option), "Express - $25.0")

        # Test another delivery option
        option2 = DeliveryOption("Standard", 5.0)
        self.assertEqual(str(option2), "Standard - $5.0")

    def test_delivery_service(self):
        service = DeliveryService()
        option1 = DeliveryOption("Express", 25.0)
        option2 = DeliveryOption("Standard", 5.0)

        service.add_delivery_option(option1)
        service.add_delivery_option(option2)

        available_options = service.get_available_options()
        self.assertEqual(len(available_options), 2)
        self.assertIn(option1, available_options)
        self.assertIn(option2, available_options)

    def test_product(self):
        prod = Product("Laptop", 1000, 5)
        self.assertTrue(prod.is_in_stock())

        # Test restocking product
        prod.restock(5)
        self.assertEqual(prod.stock, 10)

        # Test product going out of stock
        prod.stock = 0
        self.assertFalse(prod.is_in_stock())

    def test_product_service(self):
        service = ProductService()
        prod1 = Product("Laptop", 1000, 5)
        prod2 = Product("Phone", 500, 10)

        # Add products to catalog
        service.add_product(prod1)
        service.add_product(prod2)

        # Fetch product by name
        self.assertEqual(service.get_product("Laptop"), prod1)
        self.assertEqual(service.get_product("Phone"), prod2)

        # Update product price
        prod1.price = 900
        service.update_product(prod1)
        self.assertEqual(service.get_product("Laptop").price, 900)

if __name__ == '__main__':
    unittest.main()
