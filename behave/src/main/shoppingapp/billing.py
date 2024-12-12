class Billing:
    def __init__(self):
        self.total_amount = 0
        self.discount = 0

    def set_total_amount(self, total_amount):
        self.total_amount = total_amount

    def apply_discount(self, discount):
        self.discount = discount

    def calculate_final_amount(self):
        return self.total_amount - (self.total_amount * self.discount / 100)

    def validate_payment(self, card_number):
        return len(card_number) == 16 and card_number.isdigit()
