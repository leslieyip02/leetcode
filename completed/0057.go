package main

import "fmt"

func intersects(a []int, b []int) bool {
    return (a[0] <= b[0] && b[0] <= a[1] ||
            a[0] <= b[1] && b[1] <= a[1])
}

func insert(intervals [][]int, newInterval []int) [][]int {
    merged := []int{newInterval[0], newInterval[1]}
    for _, interval := range intervals {
        if intersects(interval, newInterval) {
            if interval[0] < merged[0] {
                merged[0] = interval[0]
            }
            if interval[1] > merged[1] {
                merged[1] = interval[1]
            }
        }
    }

    results := make([][]int, 0)
    inserted := false
    for _, interval := range intervals {
        if intersects(merged, interval) {
            if !inserted {
                results = append(results, merged)
                inserted = true
            }
        } else {
            if !inserted && interval[0] > merged[1] {
                results = append(results, merged)
                inserted = true
            }
            results = append(results, interval)
        }
    }
    if !inserted {
        results = append(results, merged)
    }
    return results
}

func main() {
    intervals := [][]int{{1,2},{3,5},{6,7},{8,10},{12,16}}
    newInterval := []int{4,8}
    fmt.Println(insert(intervals, newInterval))
}
