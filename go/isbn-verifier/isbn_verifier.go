package isbn

import (
	"strconv"
	"strings"
)

func IsValidISBN(isbn string) bool {
  isbn = strings.ReplaceAll(isbn, "-", "")
	splittedString := strings.Split(isbn, "")

  if len(isbn) != 10 {
    return false
  }

	sum := 0
	for i, s := range splittedString {
		switch s {
		case "X":
      if i != len(isbn) - 1{
        return false
      }
			sum += 10 * (10 - i)
		case "-":
			continue
		default:
			value, err := strconv.Atoi(s)
      if err != nil{
        return false
      }
			sum += value * (10 - i)
		}
	}

	return sum%11 == 0

}
