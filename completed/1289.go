package main

import "fmt"

func minFallingPathSum(grid [][]int) int {
    n := len(grid)
    if n == 1 {
        return grid[0][0]
    }

    dp := make([][]int, n)
    for i := 0; i < n; i++ {
        dp[i] = make([]int, n)
        dp[0][i] = grid[0][i]

    }

    minIndices := make([]int, 2)
    if grid[0][0] < grid[0][1] {
        minIndices[1] = 1
    } else {
        minIndices[0] = 1
    }
    for i := 2; i < n; i++ {
        if dp[0][i] < dp[0][minIndices[0]] {
            minIndices[1] = minIndices[0]
            minIndices[0] = i
        } else if dp[0][i] < dp[0][minIndices[1]] {
            minIndices[1] = i
        }
    }

    for i := 1; i < n; i++ {
        for j := 0; j < n; j++ {
            dp[i][j] = grid[i][j]
            if j == minIndices[0] {
                dp[i][j] += dp[i - 1][minIndices[1]]
            } else {
                dp[i][j] += dp[i - 1][minIndices[0]]
            }
        }

        minIndices[0] = 0
        minIndices[1] = 0
        if dp[i][0] < dp[i][1] {
            minIndices[1] = 1
        } else {
            minIndices[0] = 1
        }
        for j := 2; j < n; j++ {
            if dp[i][j] < dp[i][minIndices[0]] {
                minIndices[1] = minIndices[0]
                minIndices[0] = j
            } else if dp[i][j] < dp[i][minIndices[1]] {
                minIndices[1] = j
            }
        }
    }

    m := 100 * n
    for i := 0; i < n; i++ {
        if dp[n - 1][i] < m {
            m = dp[n - 1][i]
        }
    }
    return m
}

func main() {
    grid := [][]int{{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }}
    fmt.Println(minFallingPathSum(grid))
}
