package main

import "fmt"

func countStudents(students []int, sandwiches []int) int {
    i := 0
    j := 0

    c := 0
    h := len(students)
    for c < h && i < len(students) && j < len(sandwiches) {
        if students[i] == -1 {
            i = (i + 1) % len(students)
            continue
        }

        if students[i] == sandwiches[j] {
            students[i] = -1
            j++
            c = -1
            h--
        }
        i = (i + 1) % len(students)
        c++
    }
    return h
}

func main() {
    students := []int{1, 1, 0, 0}
    sandwiches := []int{0, 1, 0, 1}
    fmt.Println(countStudents(students, sandwiches))
}
