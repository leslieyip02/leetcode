class Solution:
    def isAnagram(self, s, t):
        f = {}
        for c in s:
            f[c] = f.get(c, 0) + 1
        for c in t:
            f[c] = f.get(c, 0) - 1
            if f[c] < 0:
                return False
        for v in f.values():
            if v > 0:
                return False
        return True
