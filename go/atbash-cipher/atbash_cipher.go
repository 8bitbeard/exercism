package atbash

import (
	"unicode"
)

func Atbash(s string) string {
	count := 0
	output := []rune{}
	for _, r := range s {
		switch true {
		case unicode.IsDigit(r):
			if checkIfSpaceIsNeeded(count) {
				output = append(output, ' ')
			}
			output = append(output, r)
			count++
		case unicode.IsLetter(r):
			if checkIfSpaceIsNeeded(count) {
				output = append(output, ' ')
			}
			lower := unicode.ToLower(r)
			output = append(output, 'a'+'z'-lower)
			count++
		default:
			continue
		}
	}
	return string(output)
}

func checkIfSpaceIsNeeded(count int) bool {
	if count != 0 && count%5 == 0 {
		return true
	}
	return false
}
