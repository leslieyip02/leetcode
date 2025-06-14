class Solution {
public:
    int minMaxDifference(int num) {
        string smallest = to_string(num);
        char d1 = smallest[0];
        char d2 = '0';
        replace(smallest.begin(), smallest.end(), d1, d2);

        string largest = to_string(num);
        char d3 = 'x';
        for (int i = 0; i < largest.length(); i++) {
            if (largest[i] != '9') {
                d3 = largest[i];
                break;
            }
        }
        if (d3 != 'x') {
            char d4 = '9';
            replace(largest.begin(), largest.end(), d3, d4);
        }

        return stoi(largest) - stoi(smallest);
    }
};
