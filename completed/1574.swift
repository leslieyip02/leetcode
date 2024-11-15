class Solution {
    func findLengthOfShortestSubarray(_ arr: [Int]) -> Int {
        var left = 0
        var right = arr.count - 1
        while right > 0 && arr[right - 1] <= arr[right] {
            right -= 1
        }

        var length = right
        while left < right && (left == 0 || arr[left - 1] <= arr[left]) {
            while right < arr.count && arr[left] > arr[right] {
                right += 1
            }
            length = min(right - left - 1, length)
            left += 1
        }
        return length
    }
}
