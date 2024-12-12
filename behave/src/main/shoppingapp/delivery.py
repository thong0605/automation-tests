class Delivery:
    def __init__(self):
        self.delivery_address = None
        self.delivery_date = None

    def set_delivery_address(self, address):
        self.delivery_address = address

    def set_delivery_date(self, date):
        self.delivery_date = date

    def get_delivery_details(self):
        if self.delivery_address and self.delivery_date:
            return f"Delivery to: {self.delivery_address.get_full_address()} on {self.delivery_date}"
        else:
            return "Delivery details are incomplete."
