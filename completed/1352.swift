class ProductOfNumbers {

    var prefixes: [Int] = [1]
    var rightmostZero = -1

    init() {}
    
    func add(_ num: Int) {
        if num == 0 {
            rightmostZero = prefixes.count
        }

        let last = prefixes.last!
        if last == 0 {
            prefixes.append(num)
        } else {
            prefixes.append(prefixes.last! * num)
        }
    }
    
    func getProduct(_ k: Int) -> Int {
        let last = prefixes.last!
        if last == 0 {
            return 0
        }

        let index = prefixes.count - k - 1
        if index < rightmostZero {
            return 0
        }

        let previous = prefixes[prefixes.count - k - 1]
        if previous == 0 {
            return last
        }
        return last / previous
    }
}

