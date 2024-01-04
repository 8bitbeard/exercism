package interest

const (
	lessThanZeroRate                = 3.213
	lessThanOneThousandRate         = 0.500
	lessThanFiveThousandRate        = 1.621
	moreOrEqualThanFiveThousandRate = 2.475
)

// InterestRate returns the interest rate for the provided balance.
func InterestRate(balance float64) float32 {
	switch {
	case balance < 0:
		return lessThanZeroRate
	case balance < 1000:
		return lessThanOneThousandRate
	case balance < 5000:
		return lessThanFiveThousandRate
	default:
		return moreOrEqualThanFiveThousandRate
	}
}

// Interest calculates the interest for the provided balance.
func Interest(balance float64) float64 {
	return balance * float64(InterestRate(balance) / 100.0)
}

// AnnualBalanceUpdate calculates the annual balance update, taking into account the interest rate.
func AnnualBalanceUpdate(balance float64) float64 {
  return balance + Interest(balance)
}

// YearsBeforeDesiredBalance calculates the minimum number of years required to reach the desired balance.
func YearsBeforeDesiredBalance(balance, targetBalance float64) int {
  yearsCount := 0
  for balance < targetBalance {
    balance = AnnualBalanceUpdate(balance)
    yearsCount++
  }
  return yearsCount
}
