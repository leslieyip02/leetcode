class Solution:
    def numSpecial(self, mat):
        c = 0
        for i, row in enumerate(mat):
            one = -1
            for j, col in enumerate(row):
                if col == 1:
                    if one != -1:
                        one = -1
                        break
                    one = j

            if one == -1:
                continue

            ones = 0
            for j in range(len(mat)):
                if mat[j][one] == 1:
                    ones += 1
            if ones == 1:
                c += 1

        return c
