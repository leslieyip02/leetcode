package main

import "fmt"

func rotate(matrix [][]int)  {
    n := len(matrix)
    for i := 0; i < n; i++ {
        for j := i; j < n; j++ {
            tmp := matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = tmp
        }
    }
    for i := 0; i < n; i++ {
        for j := 0; j < n / 2; j++ {
            tmp := matrix[i][j]
            matrix[i][j] = matrix[i][n - j - 1]
            matrix[i][n - j - 1] = tmp
        }
    }
}

func main() {
    matrix := [][]int{{1,2,3},{4,5,6},{7,8,9}}
    rotate(matrix)
    fmt.Println(matrix)
}
