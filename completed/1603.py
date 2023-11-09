class ParkingSystem:
    BIG = 1
    MEDIUM = 2
    SMALL = 3

    def __init__(self, big: int, medium: int, small: int):
        self.lots = {
            ParkingSystem.BIG: big,
            ParkingSystem.MEDIUM: medium,
            ParkingSystem.SMALL: small,
        }

    def addCar(self, carType: int) -> bool:
        if self.lots[carType] == 0:
            return False
        else:
            self.lots[carType] = self.lots[carType] - 1
            return True


# Your ParkingSystem object will be instantiated and called as such:
# obj = ParkingSystem(big, medium, small)
# param_1 = obj.addCar(carType)
