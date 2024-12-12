class Address:
    def __init__(self, street, city, state, zip_code):
        self.street = street
        self.city = city
        self.state = state
        self.zip_code = zip_code

    def get_full_address(self):
        return f"{self.street}, {self.city}, {self.state} {self.zip_code}"

    def __eq__(self, other):
        return (self.street == other.street and self.city == other.city and
                self.state == other.state and self.zip_code == other.zip_code)

    def __str__(self):
        return self.get_full_address()

