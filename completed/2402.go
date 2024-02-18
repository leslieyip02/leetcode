package main

import (
    "fmt"
    "sort"
)

func mostBooked(n int, meetings [][]int) int {
    counts := make([]int, n)
    bookings := make([]int, n)

    sort.Slice(meetings, func(i int, j int) bool {
        return meetings[i][0] < meetings[j][0]
    })
    for i := range meetings {
        start := meetings[i][0]
        end := meetings[i][1]
        duration := end - start

        earliest := -1
        booked := false
        for j := 0; j < n; j++ {
            // find room with earliest end time
            if earliest == -1 || bookings[j] < bookings[earliest] {
                earliest = j
            }

            // choose room j if it ends before the earliest start
            if bookings[j] <= start {
                counts[j]++
                bookings[j] = end;
                booked = true
                break
            }
        }

        // if all rooms are occupied, wait until the earliest room finishes
        if !booked {
            counts[earliest]++
            bookings[earliest] += duration;
        }
    }

    most := 0
    for i := 1; i < n; i++ {
        if counts[i] > counts[most] {
            most = i
        }
    }
    return most
}

func main() {
    n := 4
    meetings := [][]int{ { 18, 19 }, { 3, 12 }, { 17, 19 }, { 2, 13 }, { 7, 10 } }
    fmt.Println(mostBooked(n, meetings))
}
