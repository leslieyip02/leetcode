class Solution:
    def findSpecialInteger(self, arr):
        t = len(arr) // 4
        f = {}
        for i in arr:
            f[i] = f.get(i, 0) + 1
            if f[i] > t:
                return i
