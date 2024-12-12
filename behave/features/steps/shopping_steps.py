from behave import given, when, then
from src.main.shoppingapp.product import Product
from src.main.shoppingapp.cart import Cart

@given('I have a product named "{product_name}" priced at {price}')
def step_impl_given_product(context, product_name, price):
    context.product = Product(product_name, float(price), 5)
    context.cart = Cart()

@when('I add the product to my cart')
def step_impl_add_to_cart(context):
    context.cart.add_item(context.product)

@then('my cart total should be {total}')
def step_impl_cart_total(context, total):
    assert context.cart.get_total_price() == float(total), f"Expected total: {total}, but got: {context.cart.get_total_price()}"

@given('I have a cart with a total of {total}')
def step_impl_cart_with_total(context, total):
    context.cart = Cart()
    product = Product("Laptop", 1000, 5)
    context.cart.add_item(product)
    assert context.cart.get_total_price() == float(total)

@when('I checkout')
def step_impl_checkout(context):
    context.cart.clear_cart()

@then('my cart should be empty')
def step_impl_cart_empty(context):
    assert context.cart.is_empty(), "Expected cart to be empty but it is not."

@given('I have products named "{product1}" priced at {price1} and "{product2}" priced at {price2}')
def step_impl_multiple_products(context, product1, price1, product2, price2):
    context.cart = Cart()
    context.product1 = Product(product1, float(price1), 5)
    context.product2 = Product(product2, float(price2), 10)

@when('I add both products to my cart')
def step_impl_add_both_products(context):
    context.cart.add_item(context.product1)
    context.cart.add_item(context.product2)

@when('I apply a discount of {amount}')
def step_impl_apply_discount(context, amount):
    context.cart.apply_discount(float(amount))

@given('I have only {amount} in my account')
def step_impl_account_balance(context, amount):
    context.account_balance = float(amount)
    context.error_message = None

@when('I checkout multiple products')
def step_impl_checkout_multiple(context):
    if context.cart.get_total_price() > context.account_balance:
        context.error_message = "Insufficient funds"
    else:
        context.cart.clear_cart()

@then('I should see an error message "{message}"')
def step_impl_error_message(context, message):
    assert context.error_message is not None, "Error message should be set"
    assert context.error_message == message, f"Expected error message: {message}, but got: {context.error_message}"

