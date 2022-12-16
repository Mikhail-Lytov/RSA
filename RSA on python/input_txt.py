class input_txt:
    buffer = ''
    result = 0
    def __init__(self):
        file = open("1.txt", 'r')
        self.buffer = file.read()
        file.close()
        bin_result = ''.join(format(ord(x), '08b') for x in self.buffer)
        print("b" + self.buffer)

        self.result = int(bin_result, 2)
        print(type(self.result))

    def input_txt(self):
        return self.result


a = input_txt()