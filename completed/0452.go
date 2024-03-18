package main

import (
    "fmt"
    "sort"
)

func findMinArrowShots(points [][]int) int {
    sort.Slice(points, func(i int, j int) bool {
        return points[i][0] < points[j][0]
    })

    arrows := 1
    window := []int{points[0][0], points[0][1]}
    for i := 1; i < len(points); i++ {
        if points[i][0] > window[1] {
            arrows++
            window[0] = points[i][0]
            window[1] = points[i][1]
        } else {
            if points[i][0] > window[0] {
                window[0] = points[i][0]
            }
            if points[i][1] < window[1] {
                window[1] = points[i][1]
            }
        }
    }
    return arrows
}

func main() {
    points := [][]int{{10,16},{2,8},{1,6},{7,12}}
    fmt.Println(findMinArrowShots(points))
}
