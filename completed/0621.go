package main

import "fmt"

func leastInterval(tasks []byte, n int) int {
    frequency := make(map[byte]int)
    for _, task := range tasks {
        frequency[task]++
    }

    maxCount := 0
    maxCountCount := 0
    for _, count := range frequency {
        if count > maxCount {
            maxCount = count
            maxCountCount = 1
        } else if count == maxCount {
            maxCountCount++
        }
    }

    least := (maxCount - 1) * (n + 1) + maxCountCount
    if len(tasks) > least {
        least = len(tasks)
    }
    return least
}

func main() {
    tasks := []byte{'A','A','A', 'B','B','B'}
    n := 3
    fmt.Println(leastInterval(tasks, n))
}
