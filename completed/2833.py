from collections import Counter


class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        counts = Counter(moves)
        return abs(counts['L'] - counts['R']) + counts['_']

