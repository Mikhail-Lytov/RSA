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

        f =open("1.txt", "a+", encoding='UTF-8')
        f.write('\n' + str(signature_int))
        f.close()
        #print("text " + str(text))


    def check(self):
        if self.text >= self.multiplication:
            return "Плохо"




if __name__ == "__main__":
    from  input_txt import input_txt
    from input_key import input_key

    path_signature = "C:/Users/Lytov/PycharmProjects/RSA/RSA on python/1.txt"
    path_close_key = "C:/Users/Lytov/PycharmProjects/RSA/RSA on python/open key.txt"

    text = input_txt(path_signature).input_txt()
    print(4)
    key = input_key()
    key.input_close_key(path_close_key)
    close_exhibitor, multiplication = key.close_key()
    print(5)
    signature(text, close_exhibitor, multiplication)



