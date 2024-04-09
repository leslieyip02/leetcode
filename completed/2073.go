package main

import "fmt"

func timeRequiredToBuy(tickets []int, k int) int {
    t := 0
    for i := 0; i <= k; i++ {
        if tickets[i] > tickets[k] {
            t += tickets[k]
        } else {
            t += tickets[i]
        }
    }
    for i := k + 1; i < len(tickets); i++ {
        if tickets[i] > tickets[k] - 1 {
            t += tickets[k] - 1
        } else {
            t += tickets[i]
        }
    }
    return t
}

func main() {
    tickets := []int{2,3,2}
    k := 2
    fmt.Println(timeRequiredToBuy(tickets, k))
}
