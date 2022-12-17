import math
import random

from Cryptodome.Util.number import getPrime


class generation_key:
    first_number = 0
    second_number = 0
    multiplication = 0
    euler_function = 0
    open_exhibitor = getPrime(512)
    close_exhibitor = 3

    def __init__(self, second_number, first_number):
        self.second_number = second_number
        self.first_number = first_number
        self.multiplication = first_number * second_number
        self.euler_function = (first_number - 1) * (second_number - 1)
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
    a = generation_key(getPrime(1024), getPrime(1024))
    print((a.open_exhibitor))
    print(a.close_exhibitor)
    print(a.multiplication)
