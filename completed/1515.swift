class Solution {
    func getDist(_ dx: Double, _ dy: Double) -> Double {
        return (dx * dx + dy * dy).squareRoot()
    }

    func getDistSum(_ x: Double, _ y: Double, _ positions: [[Double]]) -> Double {
        var sum: Double = 0.0
        for position in positions {
            var dx = position[0] - x
            var dy = position[1] - y
            sum += getDist(dx, dy)
        }
        return sum
    }

    func getMinDistSum(_ positions: [[Int]]) -> Double {
        var x: Double = 100.0 / 2.0
        var y: Double = 100.0 / 2.0
        var doublePositions: [[Double]] = positions.map { $0.map(Double.init) }
        var directions: [[Double]] = [[0.0, 1.0], [0.0, -1.0], [1.0, 0.0], [-1.0, 0.0]]

        var step: Double = 32.0
        var epsilon: Double = 1e-8
        var current: Double = getDistSum(x, y, doublePositions)
        while step > epsilon {
            var moved = false
            for direction in directions {
                var xi = x + direction[0] * step
                var yi = y + direction[1] * step
                var distSum = getDistSum(xi, yi, doublePositions)
                if distSum < current {
                    x = xi
                    y = yi
                    current = distSum
                    moved = true
                    break
                }
            }
            if !moved {
                step /= 2.0;
            }
        }
        return current
    }
}
