package darts

import "math"

func Score(x, y float64) int {
	distanceToCenter := distanceToCenter(x, y)
	switch {
	case distanceToCenter <= 1.0:
		return 10
	case distanceToCenter <= 5.0:
		return 5
	case distanceToCenter <= 10.0:
		return 1
	default:
		return 0
	}
}

func distanceToCenter(x, y float64) float64 {
	return math.Sqrt(math.Pow(math.Abs(x), 2) + math.Pow(math.Abs(y), 2))
}
