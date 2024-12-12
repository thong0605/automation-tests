class DeliveryOption:
    def __init__(self, option_name, cost):
        self.option_name = option_name
        self.cost = cost

    def __str__(self):
        return f"{self.option_name} - ${self.cost}"
