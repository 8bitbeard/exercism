package isogram

import (
	"strings"
)

func IsIsogram(word string) bool {
  seenStrings := ""
  word = strings.ReplaceAll(word, " ", "")
  word = strings.ReplaceAll(word, "-", "")
  word = strings.ToLower(word)
  sliceWord := strings.Split(word, "")
  for _, letter := range sliceWord {
    if strings.Contains(seenStrings, letter) {
      return false
    }
    seenStrings += letter
  }

  return true
}
