package pangram

import (
	"regexp"
	"strings"
)

func IsPangram(input string) bool {

  re := regexp.MustCompile(`[^a-zA-Z]+`)

  input = strings.ToUpper(input)
  input = re.ReplaceAllString(input, "")
  inputSlice := strings.Split(input, "")

  var foundLetters string
  for _, letter := range inputSlice {
    if !strings.Contains(foundLetters, letter) {
      foundLetters += letter
    }
  }

  return len(foundLetters) == 26
}

