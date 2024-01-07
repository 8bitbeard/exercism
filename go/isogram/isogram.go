package isogram

import (
	"slices"
	"unicode"
)

func IsIsogram(word string) bool {
  seenRunes := []rune("")
  for _, r := range word {
    lowerRune := unicode.ToLower(r)
    if slices.Contains(seenRunes, lowerRune) {
      return false
    }
    if lowerRune != ' ' && lowerRune != '-' {
      seenRunes = append(seenRunes, lowerRune)
    }
  }
  return true
}
