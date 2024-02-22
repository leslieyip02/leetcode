package main

import "fmt"

func findJudge(n int, trust [][]int) int {
    x := make([]int, n)
    y := make([]int, n)
    for i := range trust {
        a := trust[i][0]
        b := trust[i][1]
        x[a - 1]++
        y[b - 1]++
    }
    for i := 0; i < n; i++ {
        if x[i] == 0 && y[i] == n - 1 {
            return i + 1
        }
    }
    return -1
}

func main() {
    n := 3
    trust := [][]int{{1,3},{2,3}}
    fmt.Println(findJudge(n, trust))
}
