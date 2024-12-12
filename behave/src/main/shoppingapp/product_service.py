class ProductService:
    def __init__(self):
        self.product_catalog = {}

    def add_product(self, product):
        self.product_catalog[product.name] = product

    def get_product(self, name):
        return self.product_catalog.get(name)

    def update_product(self, product):
        self.product_catalog[product.name] = product
