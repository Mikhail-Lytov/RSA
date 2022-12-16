import math
import random


class generation_key:
    first_512 = 2 ** 511
    second_512 = 2 ** 512 - 1
    #first_number = random.choice(simple)
    #second_number = random.choice(simple)
    first_number = 3557
    second_number = 2579
    multiplication = first_number * second_number
    euler_function = (first_number - 1) * (second_number - 1)
    open_exhibitor = 3
    close_exhibitor = 0

    def __init__(self):
        self.Open_exhibitor()
        self.Close_exibitor()

    def Open_exhibitor(self):
        while ((math.gcd(self.open_exhibitor, self.euler_function) > 1) and (
                self.open_exhibitor < self.euler_function)):
            self.open_exhibitor += 1

    def Close_exibitor(self):
        self.close_exhibitor =  pow(self.open_exhibitor, -1, self.euler_function)

    def return_key(self):
        return self.open_exhibitor,  self.close_exhibitor, self.multiplication


if __name__ == "__main__":
    a = generation_key()
    print(a.close_exhibitor)
    print(a.multiplication)
