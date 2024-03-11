func numberOfEmployeesWhoMetTarget(hours []int, target int) int {
    c := 0
    for _, h := range hours {
        if h >= target {
            c++
        }
    }
    return c
}
