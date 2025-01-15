class Solution {
    func findThePrefixCommonArray(_ A: [Int], _ B: [Int]) -> [Int] {
        var aSet = Set<Int>()
        var bSet = Set<Int>()
        var count = 0
        return zip(A, B).map { (a, b) in
            aSet.insert(a)
            bSet.insert(b)
            if aSet.contains(b) {
                count += 1
                aSet.remove(b)
                bSet.remove(b)
            }
            if bSet.contains(a) {
                count += 1
                aSet.remove(a)
                bSet.remove(a)
            }
            return count
        }
    }
}
