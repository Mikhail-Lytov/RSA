import math


class signature:
    text, close_exhibitor, multiplication = 0, 0, 0
    def __init__(self, text, close_exhibitor, multiplication, path):

        self.text = text
        self.close_exhibitor = close_exhibitor
        self.multiplication = multiplication
        self.path = path
        self.signature()

    def signature(self):

        signature_int = pow(self.text, self.close_exhibitor, self.multiplication)

        f =open(self.path, "a+", encoding='UTF-8')
        f.write('\n' + str(signature_int))
        f.close()


    def check(self):
        if self.text >= self.multiplication:
            return "Плохо"




if __name__ == "__main__":
    pass



