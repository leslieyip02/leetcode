class Solution {
    func canPlace(_ row: [Character], _ word: [Character]) -> Bool {
        var right = 0
        var index = 0
        while right < row.count {
            if row[right] == "#" {
                right += 1
                index = 0
                continue
            }

            if row[right] != " " && row[right] != word[index] {
                while right < row.count && row[right] != "#" {
                    right += 1
                }
                index = 0
                continue
            }

            right += 1
            index += 1
            if index == word.count {
                if right == row.count {
                    return true
                }

                if row[right] == "#" {
                    return true
                }

                while right < row.count && row[right] != "#" {
                    right += 1
                }
                index = 0
            }
        }
        return false
    }

    func placeWordInCrossword(_ board: [[Character]], _ word: String) -> Bool {
        var wordAsChars = Array(word)
        var reversedWordAsChars = Array(wordAsChars.reversed())

        for row in board {
            if canPlace(row, wordAsChars) || canPlace(row, reversedWordAsChars) {
                return true
            }
        }

        for i in 0 ..< board[0].count {
            var column = board.map { $0[i] }
            if canPlace(column, wordAsChars) || canPlace(column, reversedWordAsChars) {
                return true
            }
        }

        return false
    }
}
