class Solution {

    private static final int M = (int) 1e9 + 7;

    private List<Integer> sieve(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (long j = (long) i * i; j <= max; j += i) {
                isPrime[(int) j] = false;
            }
            primes.add(i);
        }
        return primes;
    }

    private long exponentiate(long base, long exponent, long mod) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent /= 2;
        }
        return result;
    }

    public int maximumScore(List<Integer> nums, int k) {
        List<Integer> primes = sieve(Collections.max(nums));
        int[] scores = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int current = nums.get(i);
            for (int prime : primes) {
                if (prime * prime > current) {
                    break;
                }
                if (current % prime != 0) {
                    continue;
                }
                while (current % prime == 0) {
                    current /= prime;
                }
                scores[i]++;
            }
            if (current > 1) {
                scores[i]++;
            }
        }

        int[] lefts = new int[nums.size()];
        Arrays.fill(lefts, -1);
        int[] rights = new int[nums.size()];
        Arrays.fill(rights, nums.size());

        Stack<Integer> scoreIndices = new Stack<>();
        for (int i = 0; i < nums.size(); i++) {
            while (!scoreIndices.empty() && scores[scoreIndices.peek()] < scores[i]) {
                rights[scoreIndices.pop()] = i;
            }
            if (!scoreIndices.empty()) {
                lefts[i] = scoreIndices.peek();
            }
            scoreIndices.push(i);
        }

        long[] subarrayCounts = new long[nums.size()];
        PriorityQueue<Pair<Integer, Integer>> indexPairs = new PriorityQueue<>((a, b) -> {
            return a.getValue() == b.getValue()
                ? a.getKey() - b.getKey()
                : b.getValue() - a.getValue();
        });
        for (int i = 0; i < nums.size(); i++) {
            subarrayCounts[i] = ((long) rights[i] - i) * ((long) i - lefts[i]);
            indexPairs.add(new Pair<>(i, nums.get(i)));
        }

        long score = 1;
        while (k > 0) {
            Pair<Integer, Integer> pair = indexPairs.poll();
            long operations = Math.min(subarrayCounts[pair.getKey()], k);
            score = (score * exponentiate(pair.getValue(), operations, M)) % M;
            k -= operations;
        }
        return (int) score;
    }
}
