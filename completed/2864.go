package main

import (
    "fmt"
    "bytes"
)

func maximumOddBinaryNumber(s string) string {
    o := 0
    z := 0
    for i := range s {
        if s[i] == '1' {
            o++
        } else {
            z++
        }
    }

    var buffer bytes.Buffer
    for o > 1 {
        buffer.WriteString("1")
        o--
    }
    for z > 0 {
        buffer.WriteString("0")
        z--
    }
    buffer.WriteString("1")
    return buffer.String()
}

func main() {
    s := "0101"
    fmt.Println(maximumOddBinaryNumber(s))
}
