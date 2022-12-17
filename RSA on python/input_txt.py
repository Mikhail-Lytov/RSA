class input_txt:
    buffer = ''
    result = 0
    def __init__(self, path_file):
        file = open(path_file, 'r', encoding='UTF-8')
        self.buffer = file.read()
        print(self.buffer)
        file.close()
        bin_result = ''.join(format(ord(x), '08b') for x in self.buffer)
        print("b" + self.buffer)

        self.result = int(bin_result, 2)
        print(type(self.result))

    def input_txt(self):
        return self.result





a = input_txt("C:/Users/Lytov/PycharmProjects/RSA/RSA on python/1.txt")