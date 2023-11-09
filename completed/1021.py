class Solution:
    def removeOuterParentheses(self, s):
        decompositions = []
        start = 0
        end = 0
        nested = 0
        while end < len(s):
            nested += 1 if s[end] == "(" else -1
            if nested == 0:
                decompositions.append(s[start + 1:end])
                start = end + 1
            end += 1

        return "".join(decompositions)


if __name__ == "__main__":
    # s = "(()())(())"
    s = "(()())(())(()(()))"

    solution = Solution()
    print(solution.removeOuterParentheses(s))
