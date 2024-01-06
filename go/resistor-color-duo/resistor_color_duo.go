package resistorcolorduo

import (
	"math"
	"slices"
)

// Value should return the resistance value of a resistor with a given colors.
func Value(colors []string) int {
	colorsSlice := []string{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"}

  colorLimit := 2
  var result int
  for index, color := range colors[:colorLimit] {
    result += slices.Index(colorsSlice, color) * int(math.Pow10(colorLimit - 1 - index))
  }

  return result
}
