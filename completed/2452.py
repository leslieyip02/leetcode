class Solution:
    def check(self, query: str, target: str) -> bool:
        edits = 0
        for c1, c2 in zip(query, target):
            if c1 != c2:
                edits += 1
                if edits > 2:
                    return False
        return True

    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        return [
            query for query in queries
            if any(self.check(query, target) for target in dictionary)
        ]

