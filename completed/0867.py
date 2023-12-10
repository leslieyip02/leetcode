class Solution:
    def transpose(self, matrix):
        transposed = [[None for _ in matrix] for _ in matrix[0]]
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                transposed[j][i] = matrix[i][j]
        return transposed
