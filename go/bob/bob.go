// Package bob should have a package comment that summarizes what it's about.
package bob

import (
	"strings"
	"unicode"
)

// Hey should have a comment documenting it.
func Hey(remark string) string {

	remark = strings.TrimSpace(remark)
	isSilence := isSilence(remark)
	isShout := isAllUpper(remark)
	isQuestion := isQuestion(remark)

	switch true {
	case isSilence:
		return "Fine. Be that way!"
	case isShout && isQuestion:
		return "Calm down, I know what I'm doing!"
	case isShout:
		return "Whoa, chill out!"
	case isQuestion:
		return "Sure."
	default:
		return "Whatever."
	}
}

func filterLetters(remark string) string {
	output := []rune{}
	for _, r := range remark {
		if unicode.IsLetter(r) {
			output = append(output, r)
		}
	}
	return string(output)
}

func isQuestion(remark string) bool {
	return strings.HasSuffix(remark, "?")
}

func isAllUpper(remark string) bool {
	remark = filterLetters(remark)
	if remark == "" {
		return false
	}
	for _, r := range remark {
		if !unicode.IsUpper(r) {
			return false
		}
	}
	return true
}

func isSilence(remark string) bool {
	return remark == ""
}
