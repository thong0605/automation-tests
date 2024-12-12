from src.main.shoppingapp.cart import Cart
class CartService:
    def __init__(self):
        self.carts = {}

    def create_cart(self, user_id):
        cart = Cart()
        self.carts[user_id] = cart
        return cart

    def get_cart(self, user_id):
        return self.carts.get(user_id)

    def checkout_cart(self, user_id):
        self.carts.pop(user_id, None)
