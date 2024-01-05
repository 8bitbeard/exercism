package collatzconjecture

import (
	"errors"
)

func CollatzConjecture(n int) (int, error) {
	iterations := 0
	if n <= 0 {
		return iterations, errors.New("Value less or equal than zero")
	}
	for n != 1 {
		if n%2 == 0 && n > 0 {
			n = n / 2
		} else {
			n = n*3 + 1
		}
		iterations++
	}
	return iterations, nil
}
