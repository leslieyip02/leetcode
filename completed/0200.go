package main

import "fmt"

func fill(grid [][]byte, islands [][]int, x0 int, y0 int) {
    m := len(grid)
    n := len(grid[0])
    for k := 0; k < 4; k++ {
        dx := 1
        dy := 0
        if k & 1 == 1 {
            dx = 0
            dy = 1
        }
        if k & 2 == 2 {
            dx *= -1
            dy *= -1
        }
        x1 := x0 + dx
        y1 := y0 + dy
        if x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && grid[y1][x1] == '1' && islands[y1][x1] == 0 {
            islands[y1][x1] = islands[y0][x0]
            fill(grid, islands, x1, y1)
        }
    }
}

func numIslands(grid [][]byte) int {
    m := len(grid)
    n := len(grid[0])
    islands := make([][]int, m)
    for i := range grid {
        islands[i] = make([]int, n)
    }

    count := 0
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == '1' {
                if islands[i][j] == 0 {
                    count++
                    islands[i][j] = count
                    fill(grid, islands, j, i)
                }
            }
        }
    }
    return count
}

func main() {
    grid := [][]byte{
        { '1', '1', '1', '1', '0' },
        { '1', '1', '0', '1', '0' },
        { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '0', '0' },
    }
    fmt.Println(numIslands(grid))
}
