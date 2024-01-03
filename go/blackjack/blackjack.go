package blackjack

import "slices"

// ParseCard returns the integer value of a card following blackjack ruleset.
func ParseCard(card string) int {
  cards := []string{"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"}
  values := []int{11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10}

  cardIndex := slices.Index(cards, card)
  if cardIndex >= 0 {
    return values[cardIndex]
  }
  return 0

	// switch card {
	// case "ace":
	// 	return 11
	// case "two":
	// 	return 2
	// case "three":
	// 	return 3
	// case "four":
	// 	return 4
	// case "five":
	// 	return 5
	// case "six":
	// 	return 6
	// case "seven":
	// 	return 7
	// case "eight":
	// 	return 8
	// case "nine":
	// 	return 9
	// case "ten", "jack", "queen", "king":
	// 	return 10
	// default:
	// 	return 0
	// }
}

// FirstTurn returns the decision for the first turn, given two cards of the
// player and one card of the dealer.
func FirstTurn(card1, card2, dealerCard string) string {
  cardOneValue := ParseCard(card1)
  cardTwoValue := ParseCard(card2)
  dealerCardValue := ParseCard(dealerCard)

	switch {
	case card1 == "ace" && card2 == "ace":
		return "P"
	case (cardOneValue + cardTwoValue == 21) && dealerCardValue < 10:
		return "W"
	case (cardOneValue + cardTwoValue == 21) && dealerCardValue >= 10:
		return "S"
  case cardOneValue + cardTwoValue < 21 && cardOneValue + cardTwoValue > 16:
    return "S"
  case cardOneValue + cardTwoValue < 17 && cardOneValue + cardTwoValue > 11 && dealerCardValue < 7:
    return "S"
	default:
		return "H"
	}
}
