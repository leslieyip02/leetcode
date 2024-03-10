package main

import "fmt"

func largestTriangleArea(points [][]int) float64 {
    n := len(points)
    largest := float64(0)
    for i := 0; i < n - 2; i++ {
        for j := i + 1; j < n - 1; j++ {
            for k := j + 1; k < n; k++ {
                sum := points[i][0] * points[j][1] +
                    points[j][0] * points[k][1] +
                    points[k][0] * points[i][1] -
                    points[i][1] * points[j][0] -
                    points[j][1] * points[k][0] -
                    points[k][1] * points[i][0]
                area := 0.5 * float64(sum)
                if area < 0 {
                    area *= -1
                }
                if area > largest {
                    largest = area
                }
            }
        }
    }
    return largest
}

func main() {
    points := [][]int{
        {0, 0},
        {0, 1},
        {1, 0},
        {0, 2},
        {2, 0},
    }
    fmt.Println(largestTriangleArea(points))
}
