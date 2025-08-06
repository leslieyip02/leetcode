class Solution {
private:
    const int NOT_FOUND = -1;

    struct MaxSegmentTree {
        vector<int> t;

        MaxSegmentTree(vector<int>& a) {
            int n = a.size();
            t = vector<int>(4 * n);
            build(a, 1, 0, n - 1);
        }

        void build(vector<int>& a, int v, int tl, int tr) {
            if (tl == tr) {
                t[v] = a[tl];
                return;
            }

            int tm = (tl + tr) / 2;
            build(a, v * 2, tl, tm);
            build(a, v * 2 + 1, tm + 1, tr);
            t[v] = max(t[v * 2], t[v * 2 + 1]);
        }

        void update(int v, int tl, int tr, int index, int value) {
            if (tl == tr) {
                t[v] = value;
                return;
            }

            int tm = (tl + tr) / 2;
            if (index <= tm) {
                update(v * 2, tl, tm, index, value);
            } else {
                update(v * 2 + 1, tm + 1, tr, index, value);
            }
            t[v] = max(t[v * 2], t[v * 2 + 1]);
        }

        int query(int v, int tl, int tr, int l, int r) {
            if (l > r) {
                return 0;
            }

            if (l <= tl && r >= tr) {
                return t[v];
            }

            int tm = (tl + tr) / 2;
            return max(
                query(v * 2, tl, tm, l, min(r, tr)),
                query(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r)
            );
        }
    };

public:
    int numOfUnplacedFruits(vector<int>& fruits, vector<int>& baskets) {
        MaxSegmentTree available(baskets);

        int n = fruits.size();
        int unplaced = 0;
        for (int fruit : fruits) {
            int left = 0;
            int right = fruits.size();
            int target = NOT_FOUND;
            while (left <= right) {
                int mid = (left + right) / 2;
                int capacity = available.query(1, 0, n - 1, 0, mid);
                if (capacity >= fruit) {
                    target = mid;                    
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (target == NOT_FOUND) {
                unplaced++;
            } else {
                available.update(1, 0, n - 1, target, 0);
            }
        }
        return unplaced;
    }
};
