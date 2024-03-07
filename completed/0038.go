package main

import "fmt"

func countAndSay(n int) string {
    if n == 1 {
        return "1"
    }

    p := countAndSay(n - 1)
    q := ""

    i := 0
    for i < len(p) {
        j := 1
        for i + j < len(p) && p[i + j] == p[i] {
            j++
        }
        q = fmt.Sprintf("%v%v%c", q, j, p[i])
        i += j
    }
    return q
}

func main() {
    n := 4
    fmt.Println(countAndSay(n))
}
