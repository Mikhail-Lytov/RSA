class input_txt:
    buffer = ''
    result = 0
    def __init__(self, path_file):
        file = open(path_file, 'r', encoding='UTF-8')
        self.buffer = file.read()
        file.close()
        bin_result = ''.join(format(ord(x), '08b') for x in self.buffer)

        self.result = int(bin_result, 2)

    def input_txt(self):
        return self.result



