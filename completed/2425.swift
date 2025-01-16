class Solution {
    func xorAllNums(_ nums1: [Int], _ nums2: [Int]) -> Int {
        let left = nums2.count % 2 == 0
            ? 0 : nums1.reduce(0, { x, y in
                x ^ y
            })
        let right = nums1.count % 2 == 0
            ? 0 : nums2.reduce(0, { x, y in
                x ^ y
            })
        return left ^ right
    }
}
