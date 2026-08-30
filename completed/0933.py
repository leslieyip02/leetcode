class RecentCounter:

    WINDOW = 3000

    def __init__(self):
        self.requests = []

    def ping(self, t: int) -> int:
        self.requests.append(t)

        left = 0
        while left < len(self.requests):
            if t - self.requests[left] <= self.WINDOW:
                break
            left += 1
        self.requests = self.requests[left:]

        return len(self.requests)

# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)
