package main

import "fmt"

func matrixScore(grid [][]int) int {
    m := len(grid)
    n := len(grid[0])

    for i := 0; i < m; i++ {
        // flip row
        if grid[i][0] == 0 {
            for j := 0; j < n; j++ {
                if grid[i][j] == 0 {
                    grid[i][j] = 1
                } else {
                    grid[i][j] = 0
                }
            }
        }
    }

    ones := make([]int, n)
    ones[0] = m
    for j := 1; j < n; j++ {
        c := 0
        for i := 0; i < m; i++ {
            if grid[i][j] == 1 {
                c++
            }
        }

        if c > m / 2 {
            ones[j] = c
        } else {
            ones[j] = m - c
        }
    }

    score := 0
    for i, c := range ones {
        score += (1 << (n - i - 1)) * c
    }
    return score
}

func main() {
    grid := [][]int{
        { 0, 0, 1, 1 },
        { 1, 0, 1, 0 },
        { 1, 1, 0, 0 },
    }
    fmt.Println(matrixScore(grid))
}
