package bottlesong

import (
	"fmt"
	"strings"
)

var bottlesAmount = []string{
  "No green bottles",
  "One green bottle",
  "Two green bottles",
  "Three green bottles",
  "Four green bottles",
  "Five green bottles",
  "Six green bottles",
  "Seven green bottles",
  "Eight green bottles",
  "Nine green bottles",
  "Ten green bottles",
}

func Recite(startBottles, takeDown int) []string {
	output := []string{}
  for i := startBottles; i > startBottles - takeDown; i-- {
    output = append(output, buildVerse(i)...)
  }
  return output[:len(output)-1]
}

func buildVerse(bottles int) []string {
	templateOne := "%s hanging on the wall,"
	templateTwo := "There'll be %s hanging on the wall."
	return []string{
		fmt.Sprintf(templateOne, bottlesAmount[bottles]),
		fmt.Sprintf(templateOne, bottlesAmount[bottles]),
		"And if one green bottle should accidentally fall,",
		fmt.Sprintf(templateTwo, strings.ToLower(bottlesAmount[bottles-1])),
		"",
	}
}
