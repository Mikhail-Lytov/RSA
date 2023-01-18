from Cryptodome.Util.number import getPrime

class Prime_Number:
    first = 0
    second = 0
    def __init__(self, size):
        self.firsrt = getPrime(size)
        self.second = getPrime(size)

        print(self.firsrt)
        print(self.second)

    def number(self):
        return self.firsrt, self.second

if __name__ == "__main__":
    prime = Prime_Number(1024)
