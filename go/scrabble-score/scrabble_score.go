package scrabble

import "unicode"

func Score(word string) int {
	score := 0
	for _, r := range word {
		score += getRunePoints(r)
	}
	return score
}

func getRunePoints(r rune) int {
	switch unicode.ToUpper(r) {
	case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T':
		return 1
	case 'D', 'G':
		return 2
	case 'B', 'C', 'M', 'P':
		return 3
	case 'F', 'H', 'V', 'W', 'Y':
		return 4
	case 'K':
		return 5
	case 'J', 'X':
		return 8
	case 'Q', 'Z':
		return 10
	default:
		return 0
	}
}
