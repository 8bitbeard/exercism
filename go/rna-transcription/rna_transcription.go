package strand

var transcriptMap = map[rune]rune{
  'G': 'C',
  'C': 'G',
  'T': 'A',
  'A': 'U',
}

func ToRNA(dna string) string {
  output := make([]rune, len(dna))
  for idx, n := range dna {
    output[idx] = transcriptMap[n]
  }
  return string(output)
}
