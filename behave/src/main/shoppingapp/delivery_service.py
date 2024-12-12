class DeliveryService:
    def __init__(self):
        self.delivery_options = []

    def add_delivery_option(self, option):
        self.delivery_options.append(option)

    def get_available_options(self):
        return self.delivery_options
