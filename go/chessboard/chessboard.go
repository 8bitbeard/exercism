package chessboard

// Declare a type named File which stores if a square is occupied by a piece - this will be a slice of bools
type File [8]bool

// Declare a type named Chessboard which contains a map of eight Files, accessed with keys from "A" to "H"
type Chessboard map[string]File

// CountInFile returns how many squares are occupied in the chessboard,
// within the given file.
func CountInFile(cb Chessboard, file string) (occupiedCount int) {
  if foundFile, ok := cb[file]; ok {
    for _, occupied := range foundFile {
      if occupied {
        occupiedCount++
      }
    }
  }

  return
}

// CountInRank returns how many squares are occupied in the chessboard,
// within the given rank.
func CountInRank(cb Chessboard, rank int) (occupiedSquares int) {
  if rank < 1 || rank > 8 {
    return 0
  }

  for _, file := range cb {
    if file[rank-1] {
      occupiedSquares++
    }
  }

  return
}

// CountAll should count how many squares are present in the chessboard.
func CountAll(cb Chessboard) int {
  return len(cb) * len(cb["A"])
}

// CountOccupied returns how many squares are occupied in the chessboard.
func CountOccupied(cb Chessboard) (occupiedSquares int) {
  for k := range cb {
    occupiedSquares += CountInFile(cb, k)
  }

  return
}
