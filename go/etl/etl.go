package etl

import "strings"

func Transform(in map[int][]string) map[string]int {
  newMap := make(map[string]int)
  for key, value := range in {
    for _, letter := range value {
      newMap[strings.ToLower(letter)] = key
    }
  }
  return newMap
}
