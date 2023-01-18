from generation_key import generation_key

class output_key:
    def __init__(self, first_prime, second_prime):
        key = generation_key(first_prime, second_prime)
        open_exhibitor, close_exhibitor, multiplication = key.return_key()
        self.output_open_key(open_exhibitor, multiplication)
        self.output_close_key(close_exhibitor, multiplication)

    def output_open_key(self, open_exhibitor, multiplication):
        file = open("open key.txt", "w+")
        text = str(open_exhibitor) + "\n" + str(multiplication)
        file.write(text)
        file.close()
    def output_close_key(self, close_exhibitor, multiplication):
        file = open("close key.txt", "w+")
        text = str(close_exhibitor) + "\n" + str(multiplication)
        file.write(text)
        file.close()

if __name__ == "__main__":
    output_key(3, 11)