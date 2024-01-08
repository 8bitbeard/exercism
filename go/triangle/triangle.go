// This is a "stub" file.  It's a little start on your solution.
// It's not a complete solution though; you have to write some code.

// Package triangle should have a package comment that summarizes what it's about.
// https://golang.org/doc/effective_go.html#commentary
package triangle

// Notice KindFromSides() returns this type. Pick a suitable data type.
type Kind int

const (
	// Pick values for the following identifiers used by the test program.
	NaT = 0 // not a triangle
	Equ = 1 // equilateral
	Iso = 2 // isosceles
	Sca = 3 // scalene
)

// KindFromSides should have a comment documenting it.
func KindFromSides(a, b, c float64) Kind {
	var k Kind
  if a == 0 || b == 0 || c == 0 {
    k = NaT
    return k
  }
	if a+b < c || b+c < a || a+c < b {
		k = NaT
    return k
	}

	set := make(map[float64]int)
	set[a] += 1
	set[b] += 1
	set[c] += 1

	switch len(set) {
	case 1:
		k = 1
	case 2:
		k = 2
	default:
		k = 3
	}

	return k
}
