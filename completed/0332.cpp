#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <stack>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        map<string, multiset<string>> airports;
        for (auto ticket : tickets) {
            string from = ticket.front();
            string to = ticket.back();
            if (airports.find(from) == airports.end()) {
                airports[from] = multiset<string>();
            }
            airports[from].insert(to);
        }

        // DFS
        stack<string> itinerary;
        itinerary.push("JFK");
        string previous, current, next;
        while (itinerary.size() <= tickets.size()) {
            current = itinerary.top();
            if (!airports[current].empty()) {
                auto itr = airports[current].upper_bound(previous);
                if (itr != airports[current].end()) {
                    next = *itr;
                    airports[itinerary.top()].erase(itr);
                    itinerary.push(next);
                    previous = "";
                } else {
                    itinerary.pop();
                    airports[itinerary.top()].insert(current);
                    previous = current;
                }
            } else {
                itinerary.pop();
                airports[itinerary.top()].insert(current);
                previous = current;
            }
        }

        vector<string> order;
        while (!itinerary.empty()) {
            order.push_back(itinerary.top());
            itinerary.pop();
        }
        reverse(order.begin(), order.end());
        return order;
    }
};

int main() {
    vector<vector<string>> tickets = {
        { "MUC", "LHR" },
        { "JFK", "MUC" },
        { "SFO", "SJC" },
        { "LHR", "SFO" }
    };

    Solution solution;
    auto results = solution.findItinerary(tickets);
    for (auto result : results) {
        cout << result << " ";
    }
    cout << endl;

    tickets = {
        { "JFK", "SFO" },
        { "JFK", "ATL" },
        { "SFO", "ATL" },
        { "ATL", "JFK" },
        { "ATL", "SFO" }
    };
    results = solution.findItinerary(tickets);
    for (auto result : results) {
        cout << result << " ";
    }
    cout << endl;

    tickets = {
        { "EZE", "AXA" },
        { "TIA", "ANU" },
        { "ANU", "JFK" },
        { "JFK", "ANU" },
        { "ANU", "EZE" },
        { "TIA", "ANU" },
        { "AXA", "TIA" },
        { "TIA", "JFK" },
        { "ANU", "TIA" },
        { "JFK", "TIA" }
    };
    results = solution.findItinerary(tickets);
    for (auto result : results) {
        cout << result << " ";
    }
    cout << endl;
    return 0;
}
