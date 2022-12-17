class input_signature:
    buffer = ''
    signature = 0
    def __init__(self):
        pass

    def input(self, path):
        f =open(path, 'r', encoding='UTF-8')
        lines = f.readlines()
        self.signature = int(lines[len(lines) - 1])
        for i in range(0, len(lines) - 1):
            self.buffer += lines[i]
        li = []
        for element in self.buffer:
            li.append(element)
        li.pop()
        print(li)
        self.buffer = ''
        for i in li:
            self.buffer += i

        print(self.buffer)
    def getText(self):
        return self.buffer
    def getSignaturee(self):
        return self.signature

input_signature()