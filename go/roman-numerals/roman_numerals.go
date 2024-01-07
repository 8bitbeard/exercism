package romannumerals

import (
	"errors"
	"strings"
)

func ToRomanNumeral(input int) (string, error) {
  if input < 1 || input > 3999 {
    return "", errors.New("Invalid input")
  }

  output := ""
  buff := input / 1000
  output += strings.Repeat("M", buff)

  input = input % 1000
  buff = input / 100
  output += strings.Repeat("C", buff)

  input = input % 100
  buff = input / 10
  output += strings.Repeat("X", buff)

  input = input % 10
  buff = input / 1
  output += strings.Repeat("I", buff)

  output = strings.ReplaceAll(output, "IIIIIIIII", "IX")
  output = strings.ReplaceAll(output, "IIIII", "V")
  output = strings.ReplaceAll(output, "IIII", "IV")
  output = strings.ReplaceAll(output, "XXXXXXXXX", "XC")
  output = strings.ReplaceAll(output, "XXXXX", "L")
  output = strings.ReplaceAll(output, "XXXX", "XL")
  output = strings.ReplaceAll(output, "CCCCCCCCC", "CM")
  output = strings.ReplaceAll(output, "CCCCC", "D")
  output = strings.ReplaceAll(output, "CCCC", "CD")

  return output, nil

}
