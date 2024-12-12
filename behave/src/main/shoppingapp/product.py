class Product:
    def __init__(self, name, price, stock):
        self.name = name
        self.price = price
        self.stock = stock

    def restock(self, quantity):
        self.stock += quantity

    def is_in_stock(self):
        return self.stock > 0
