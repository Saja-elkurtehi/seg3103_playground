def div(number1, number2):
    if number2 == 0:
        raise ZeroDivisionError("Division by zero is not allowed.")
    else:
        return number1 / number2
