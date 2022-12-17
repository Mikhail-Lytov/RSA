class input_key:
    open_exhibitor = 0
    close_exhibitor = 0
    multiplication = 0
    def __init__(self):
        pass
    #    self.input_open_key(path_open_key)
    #    self.input_close_key(path_close_key)

    def input_open_key(self, path_open_key):
        if(path_open_key != None):
            file = open(path_open_key, "r",encoding='UTF-8')
            self.open_exhibitor = int(file.readline())
            self.multiplication = int(file.readline())
            file.close()

    def input_close_key(self,path_close_key):
        if(path_close_key != None):
            file = open("close key.txt", 'r',encoding='UTF-8')
            self.close_exhibitor = int(file.readline())
            self.multiplication = int(file.readline())
            file.close()
            print(self.close_exhibitor)
            print(self.multiplication)
    def open_key(self):
        return self.open_exhibitor, self.multiplication

    def close_key(self):
        return  self.close_exhibitor, self.multiplication



if __name__ == "__main__":
    path_close_key = "C:/Users/Lytov/PycharmProjects/RSA/RSA on python/open key.txt"
    a = input_key()
    a.input_close_key(path_close_key)
    close_exhibitor, multiplication = a.close_key()