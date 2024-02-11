package main

import "fmt"


func cherryPickup(grid [][]int) int {
    rows := len(grid)
    cols := len(grid[0])
    memo := make([][][]int, rows)
    for i := range memo {
        memo[i] = make([][]int, cols)
        for j := range memo[i] {
            memo[i][j] = make([]int, cols)
            for k := range memo[i][j] {
                memo[i][j][k] = -1
            }
        }
    }

    var collect func(row int, col1 int, col2 int) int
    collect = func(row int, col1 int, col2 int) int {
        if memo[row][col1][col2] != -1 {
            return memo[row][col1][col2]
        }

        count := grid[row][col1]
        if (col2 != col1) {
            count += grid[row][col2]
        }

        if row != rows - 1 {
            max := 0
            for i := -1; i <= 1; i++ {
                if col1 + i < 0 || col1 + i >= cols {
                    continue
                }

                for j := -1; j <= 1; j++ {
                    if col2 + j < 0 || col2 + j >= cols {
                        continue
                    }

                    current := collect(row + 1, col1 + i, col2 + j)
                    if current > max {
                        max = current
                    }
                }
            }
            count += max
        }
        memo[row][col1][col2] = count
        return count
    }

    return collect(0, 0, cols - 1)
}

func main() {
    grid := [][]int{
        { 3, 1, 1 },
        { 2, 5, 1 },
        { 1, 5, 5 },
        { 2, 1, 1 },
    }
    fmt.Println(cherryPickup(grid))
}
