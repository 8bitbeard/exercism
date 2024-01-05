package hamming

import (
	"errors"
	"strings"
)

func Distance(a, b string) (int, error) {
  diffCount := 0

  if len(a) != len(b) {
    return diffCount, errors.New("The sequences must have the same lenght!")
  }

  sliceA := strings.Split(a, "")
  sliceB := strings.Split(b, "")

  for i := range sliceA {
    if sliceA[i] != sliceB[i] {
      diffCount++
    }
  }

  return diffCount, nil
}
