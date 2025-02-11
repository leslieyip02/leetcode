class Solution {
    func removeOccurrences(_ s: String, _ part: String) -> String {
        var stack: Deque<Character> = []
        for letter in s {
            stack.append(letter)
            if stack.count >= part.count {
                if String(stack.suffix(part.count)) == part {
                    stack.removeLast(part.count)
                }
            }
        }
        return String(stack)
    }
}

