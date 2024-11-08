class Solution {
    func restoreArray(_ adjacentPairs: [[Int]]) -> [Int] {
        var adjacents: [Int: [Int]] = [:]
        for pair in adjacentPairs {
            adjacents[pair[0], default: []].append(pair[1])
            adjacents[pair[1], default: []].append(pair[0])
        }

        var restored: [Int] = []
        for (key, value) in adjacents {
            if value.count == 1 {
                restored.append(key)
                break
            }
        }

        while adjacents.count > 0 {
           let previous = restored.last!
           for adjacent in adjacents[previous]! {
                if adjacents[adjacent] != nil {
                    restored.append(adjacent)
                    break
                }
           }
           adjacents.removeValue(forKey: previous)
        }
        return restored
    }
}
