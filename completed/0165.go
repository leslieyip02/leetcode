package main

import (
    "fmt"
    "strings"
    "strconv"
)

func compareVersion(version1 string, version2 string) int {
    t1 := strings.Split(version1, ".")
    t2 := strings.Split(version2, ".")

    m := len(t1)
    n := len(t2)
    l := m
    if n > m {
        l = n
    }
    for i := 0; i < l; i++ {
        d1 := 0
        d2 := 0
        if i < m {
            d1, _ = strconv.Atoi(strings.TrimLeft(t1[i], "0"))
        }
        if i < n {
            d2, _ = strconv.Atoi(strings.TrimLeft(t2[i], "0"))
        }

        if d1 < d2 {
            return -1
        } else if d1 > d2 {
            return 1
        }
    }
    return 0
}

func main() {
    version1 := "1.01"
    version2 := "1.001.1"
    fmt.Println(compareVersion(version1, version2))
}
