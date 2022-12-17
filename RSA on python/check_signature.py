class check_signature:
    signature_text = ''
    signature, open_exhibitor, multiplication = 0, 0, 0
    path_signature = ""
    def __init__(self, open_exhibitor, multiplication, signature_text, signature, path_signature):
        self.signature_text = signature_text
        self.signature = signature
        self.open_exhibitor = open_exhibitor
        self.multiplication = multiplication
        self.path_signature = path_signature
        self.check()

    def check(self):
        messeg = pow(int(self.signature), self.open_exhibitor, self.multiplication)
        if (messeg == self.text_int(self.signature_text)):
            print("ура")
            print(self.path_signature)
            file = open(self.path_signature, "w", encoding='UTF-8')
            file.write(self.signature_text)
            file.close()
        else:
            print("не ура")


    def text_int(self, text):
        bin_result = ''.join(format(ord(x), '08b') for x in text)
        return int(bin_result, 2)





if __name__ == "__main__":
    from input_key import input_key
    from input_signature import input_signature

    key = input_key()
    print(2)
    key.input_open_key("C:/Users/Lytov/PycharmProjects/RSA/RSA on python/open key.txt")
    print(3)
    open_exhibitor, multiplication = key.open_key()

    sig = input_signature()

    path = "C:/Users/Lytov/PycharmProjects/RSA/RSA on python/1.txt"
    sig.input(path)
    signature_text = sig.getText()

    signature = sig.getSignaturee()

    a = check_signature(open_exhibitor, multiplication, signature_text, signature, path)