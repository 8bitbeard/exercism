package luhn

import (
	"slices"
	"strconv"
	"strings"
)

func Valid(id string) bool {
  id = strings.ReplaceAll(id, " ", "")
  if len(id) < 2 {
    return false
  }
  idSlice := strings.Split(id, "")
  slices.Reverse(idSlice)

  sum := 0
  for i, s := range idSlice {
    value, err := strconv.Atoi(s)
    if err != nil {
      return false
    }

    if i % 2 != 0 {
      value *= 2
      if value > 9 {
        value -= 9
      }
    }

    sum += value
  }

  return sum % 10 == 0
}
