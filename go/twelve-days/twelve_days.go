package twelve

import (
	"fmt"
	"strings"
)

var days = [...]string{
		"first",
		"second",
		"third",
		"fourth",
		"fifth",
		"sixth",
		"seventh",
		"eighth",
		"ninth",
		"tenth",
		"eleventh",
		"twelfth",
}
var	items = [...]string{
		"twelve Drummers Drumming,",
		"eleven Pipers Piping,",
		"ten Lords-a-Leaping,",
		"nine Ladies Dancing,",
		"eight Maids-a-Milking,",
		"seven Swans-a-Swimming,",
		"six Geese-a-Laying,",
		"five Gold Rings,",
		"four Calling Birds,",
		"three French Hens,",
		"two Turtle Doves, and",
		"a Partridge in a Pear Tree",
	}

func Verse(i int) string {
	template := "On the %s day of Christmas my true love gave to me: %s."

	return fmt.Sprintf(template, days[i-1], strings.Join(items[len(items)-i:], " "))
}

func Song() (song string) {
	for i := 1; i <= 12; i++ {
		song += Verse(i) + "\n"
	}
	return strings.TrimSpace(song)
}
