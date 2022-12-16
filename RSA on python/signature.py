import math


class signature:
    text, close_exhibitor, multiplication = 0, 0, 0
    def __init__(self, text, close_exhibitor, multiplication):

        self.text = text
        self.close_exhibitor = close_exhibitor
        self.multiplication = multiplication
        self.signature()

    def signature(self):

        signature_int = pow(self.text, self.close_exhibitor, self.multiplication)

        f =open("1.txt", "a+")
        f.write('\n' + str(signature_int))
        f.close()
        print("text " + str(text))


    def check(self):
        if self.text >= self.multiplication:
            return "Плохо"




if __name__ == "__main__":
    from  input_txt import input_txt
    from input_key import input_key

    text = input_txt().input_txt()
    key_file = input_key()
    close_exhibitor, multiplication = key_file.close_key()
    a = signature(text, close_exhibitor, multiplication)



