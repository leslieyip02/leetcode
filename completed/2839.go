func canBeEqual(s1 string, s2 string) bool {
    if s1 == s2 {
        return true
    }

    ok := false
    for i := 0; i < 4; i++ {
        if s1[i] != s2[i] {
            ok = true
        }
    }

    if ok {
        if (s1[0] != s2[0] || s1[2] != s2[2]) && !(s1[0] == s2[2] && s1[2] == s2[0]) {
            return false
        }
        if (s1[1] != s2[1] || s1[3] != s2[3]) && !(s1[1] == s2[3] && s1[3] == s2[1]) {
            return false
        }
        return true
    } else {
        return false
    }
}
