package main

import "fmt"

func avoidFlood(rains []int) []int {
    lakes := make(map[int]int)
    dryIndices := make([]int, 0)
    ans := make([]int, len(rains))
    for i := range rains {
        if rains[i] == 0 {
            dryIndices = append(dryIndices, i)
            // default drain 1
            ans[i] = 1
        } else {
            rainIndex, present := lakes[rains[i]]
            if present && rainIndex != -1 {
                if len(dryIndices) == 0 {
                    return make([]int, 0)
                }

                // binary search for dry index
                lo := 0
                hi := len(dryIndices) - 1
                mid := (lo + hi) / 2
                for lo < hi {
                    if dryIndices[mid] > rainIndex {
                        hi = mid
                    } else {
                        lo = mid + 1
                    }
                    mid = (lo + hi) / 2
                }

                // make sure the dry index is after the rain
                if dryIndices[mid] < rainIndex {
                    return make([]int, 0)
                }

                ans[dryIndices[mid]] = rains[i]
                dryIndices = append(dryIndices[:mid], dryIndices[mid + 1:]...)
            }
            lakes[rains[i]] = i
            ans[i] = -1
        }
    }
    return ans
}

func main() {
    rains := []int{1, 0, 2, 0, 2, 1}
    fmt.Println(avoidFlood(rains))
}
