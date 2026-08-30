class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:
        # Adapted from https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii/solutions/8314335/easy-solution-sliding-window-clever-math-tcix

        def is_wave_pattern(num: int) -> bool:
            left, target, right = [int(i) for i in str(num).zfill(3)]
            return (target < left and target < right) or (target > left and target > right)
        
        wave_patterns = [num for num in range(1000) if is_wave_pattern(num)]

        def get_waviness(num: int) -> int:
            if num < 100:
                return 0

            s = str(num)
            waviness = 0
            for pattern in wave_patterns:
                zero_padded = pattern < 100

                for i in range(len(s) - 2):
                    prefix = 0 if i == 0 else int(s[:i])
                    target = int(s[i:i + 3])
                    suffix = 0 if i + 3 == len(s) else int(s[i + 3:])

                    suffix_multiplier = 10 ** (len(s) - i - 3)
                    if target > pattern:
                        waviness += (prefix + (not zero_padded)) * suffix_multiplier
                    elif target < pattern:
                        waviness += (prefix - zero_padded) * suffix_multiplier
                    else:
                        waviness += (prefix - zero_padded) * suffix_multiplier + (suffix + 1)

            return waviness

        return get_waviness(num2) - get_waviness(num1 - 1)

