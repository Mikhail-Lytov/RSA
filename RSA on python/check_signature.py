class check_signature:
    signature_text = ''
    signature, open_exhibitor, multiplication = 0, 0, 0
    path_signature = ""
    result = ''
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
            file = open(self.path_signature, "w", encoding='UTF-8')
            file.write(self.signature_text)
            file.close()
            self.result = "текст подлинный"
        else:
            self.result = "текст поделка"

    def result_check(self):
        return self.result


    def text_int(self, text):
        bin_result = ''.join(format(ord(x), '08b') for x in text)
        return int(bin_result, 2)





if __name__ == "__main__":
    pass