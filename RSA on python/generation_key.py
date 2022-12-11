import math
import random
from Simple_number import simple


class generation_key:
    first_512 = 2 ** 511
    second_512 = 2 ** 512 - 1
    #first_number = random.choice(simple)
    #second_number = random.choice(simple)
    first_number = 95763725199100590817594517883972587339230629927001804303445350432102477473376363690208104523959424131445190640443723804745622232720787413093487402765562002816228922663064586830411357737817082610832942861638464623057692401649534001253562301804531014546992361693636155544294478459299905184382914484724299447667
    second_number = 169673974711464598555379554281385808812757839947605787282286570556595298581640143904112827805814949034347016020947154062944819611481475901027807345581408273664882528209899649821060414242436921777958138626316902218732742204904719270112764705990510809284427503016625738630341355222249310616384723584559623483413
    multiplication = first_number * second_number
    euler_function = (first_number - 1) * (second_number - 1)
    open_exhibitor = random.randint(first_512, second_512)
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
    generation_key()
