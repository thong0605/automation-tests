class Cart:
    def __init__(self):
        self.items = []
        self.total_amount = 0

    def add_item(self, product):
        self.items.append(product)
        self.total_amount += product.price

    def clear_cart(self):
        self.items.clear()
        self.total_amount = 0

    def get_total_price(self):
        return self.total_amount

    def apply_discount(self, amount):
        self.total_amount -= amount

    def remove_item(self, product):
        self.items.remove(product)
        self.total_amount -= product.price

    def is_empty(self):
        return len(self.items) == 0
