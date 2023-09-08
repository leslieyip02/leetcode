#include <iostream>
#include <vector>
#include <map>
#include <unordered_set>
using namespace std;

class Encrypter {
private:
    map<char, string> encrypted;
    unordered_set<string> permitted;

public:
    Encrypter(vector<char>& keys, vector<string>& values, vector<string>& dictionary) {
        for (int i = 0; i < keys.size(); i++) {
            encrypted[keys[i]] = values[i];
        }
        for (string word : dictionary) {
            permitted.insert(word);
        }
    }
    
    string encrypt(string word1) {
        string result = "";
        for (char c : word1) {
            if (encrypted.find(c) == encrypted.end()) {
                return "";
            }
            result += encrypted[c];
        }
        return result;
    }
    
    int decrypt(string word2) {
        int n = 0;
        for (string p : permitted) {
            if (encrypt(p) == word2) {
                n++;
            }
        }
        return n;
    }
};

int main() {
    vector<char> keys = { 'a', 'b', 'c', 'd' };
    vector<string> values = { "ei", "zf", "ei", "am" };
    vector<string> dictionary = { "abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad" };
    Encrypter* encrypter = new Encrypter(keys, values, dictionary);

    string word1 = "abcd";
    string word2 = "eizfeiam";
    cout << encrypter->encrypt(word1) << endl;
    cout << encrypter->decrypt(word2) << endl;
    return 0;
}