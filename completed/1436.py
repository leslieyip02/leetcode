class Solution:
    def destCity(self, paths):
        src = set()
        dst = set()
        for a, b in paths:
            src.add(a)
            dst.add(b)
        for a in dst:
            if a not in src:
                return a
