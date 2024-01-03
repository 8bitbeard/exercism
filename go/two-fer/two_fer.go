// Package twofer to generate the two fer sentence
package twofer

import "fmt"

// ShareWith function to return the two fer sentence
func ShareWith(name string) string {
	return fmt.Sprintf("One for %s, one for me.", validateName(name))
}

func validateName(name string) string {
  if name == "" {
    return "you"
  }
  return name
}
