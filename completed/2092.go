package main

import (
    "fmt"
    "sort"
)

func findAllPeople(n int, meetings [][]int, firstPerson int) []int {
    parents := make([]int, n)
    for i := range parents {
        parents[i] = i
    }
    parents[firstPerson] = 0

    var find func(person int) int
    find = func(person int) int {
        if parents[person] != person {
            parent := find(parents[person])
            parents[person] = parent
        }
        return parents[person]
    }
    var union = func(parent int, child int) {
        parents[find(child)] = find(parent)
    }
    var reset = func(person int) {
        parents[person] = person
    }

    sort.Slice(meetings, func(i int, j int) bool {
        return meetings[i][2] < meetings[j][2];
    })
    for i := 0; i < len(meetings); i++ {
        same := make(map[int]bool)

        j := i
        for j < len(meetings) && meetings[i][2] == meetings[j][2] {
            same[meetings[j][0]] = true
            same[meetings[j][1]] = true
            union(meetings[j][0], meetings[j][1])
            j++
        }
        i = j - 1;

        target := find(0)
        for person := range same {
            if find(person) != target {
                reset(person)
            }
        }
    }

    target := find(0)
    know := make([]int, 0)
    for i := range parents {
        if find(i) == target {
            know = append(know, i)
        }
    }
    return know
}

func main() {
    n := 11
    meetings := [][]int{ { 5, 1, 4 }, { 0, 4, 18 } }
    firstPerson := 1
    fmt.Println(findAllPeople(n, meetings, firstPerson))
}
