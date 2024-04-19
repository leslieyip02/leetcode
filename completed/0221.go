func maximalSquare(matrix [][]byte) int {
    m := len(matrix)
    n := len(matrix[0])
    dp := make([][]int, m)
    for i := range dp {
        dp[i] = make([]int, n)
    }

    s := 0
    for i := 0; i < m; i++ {
        if matrix[i][0] == '1' {
            dp[i][0] = 1
            s = 1
        }
    }
    for i := 0; i < n; i++ {
        if matrix[0][i] == '1' {
            dp[0][i] = 1
            s = 1
        }
    }

    for i := 1; i < m; i++ {
        for j := 1; j < n; j++ {
            if matrix[i][j] == '1' {
                w := dp[i - 1][j - 1]
                if dp[i - 1][j] < w {
                    w = dp[i - 1][j]
                }
                if dp[i][j - 1] < w {
                    w = dp[i][j - 1]
                }
                dp[i][j] = w + 1
                if dp[i][j] > s {
                    s = dp[i][j]
                }
            }
        }
    }
    return s * s
}
