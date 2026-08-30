class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        cost_counts = [0] * (max(costs) + 1)
        for cost in costs:
            cost_counts[cost] += 1

        bars = 0
        for cost, count in enumerate(cost_counts):
            if count == 0:
                continue

            if cost * count <= coins:
                coins -= cost * count
                bars += count
            else:
                bars += coins // cost
                break
        return bars
