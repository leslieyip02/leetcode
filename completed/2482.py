class Solution:
    def onesMinusZeros(self, grid):
        m = len(grid)
        n = len(grid[0])
        rows = [0] * m
        cols = [0] * n
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    rows[i] += 1
        for i in range(n):
            for j in range(m):
                if grid[j][i] == 1:
                    cols[i] += 1

        result = [
            [
                2 * (rows[i] + cols[j]) - m - n
                for j in range(n)
            ]
            for i in range(m)
        ]
        return result
