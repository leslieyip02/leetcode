import functools
import math


class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        @functools.cache
        def maxDiff(index: int) -> int:
            if index == len(stoneValue):
                return 0

            best_score = -math.inf
            for count in (1, 2, 3):
                if index + count > len(stoneValue):
                    break
                best_score = max(
                    sum(stoneValue[index:index+count]) - maxDiff(index + count),
                    best_score
                )
            return best_score

        if (score := maxDiff(0)) > 0:
            return "Alice"
        elif score < 0:
            return "Bob"
        else:
            return "Tie"

