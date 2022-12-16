class input_key:
    open_exhibitor = 0
    close_exhibitor = 0
    multiplication = 0
    def __init__(self):
        self.input_open_key()
        self.input_close_key()

    def input_open_key(self):
        file = open("open key.txt", "r")
        self.open_exhibitor = int(file.readline())
        self.multiplication = int(file.readline())
        file.close()

    def input_close_key(self):
        file = open("close key.txt", 'r')
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
    input_key()