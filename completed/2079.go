package main

import "fmt"

func wateringPlants(plants []int, capacity int) int {
    v := capacity
    s := 0
    for i := range plants {
        if plants[i] > v {
            s += i * 2
            v = capacity
        }
        s++
        v -= plants[i]
    }
    return s
}

func main() {
    plants := []int{2,2,3,3,}
    capacity := 5
    fmt.Println(wateringPlants(plants, capacity))
}
