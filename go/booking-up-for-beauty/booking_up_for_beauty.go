package booking

import (
	"fmt"
	// "strings"
	"time"
)

// Schedule returns a time.Time from a string containing a date.
func Schedule(date string) time.Time {
	layout := "1/2/2006 15:04:05"
	parsedTime, _ := time.Parse(layout, date)

	return parsedTime
}

// HasPassed returns whether a date has passed.
func HasPassed(date string) bool {
	layout := "January 2, 2006 15:04:05"
	parsedTime, _ := time.Parse(layout, date)
	nowTime := time.Now()

	return nowTime.Sub(parsedTime) > 0
}

// IsAfternoonAppointment returns whether a time is in the afternoon.
func IsAfternoonAppointment(date string) bool {
	layout := "Monday, January 2, 2006 15:04:05"
	parsedTime, _ := time.Parse(layout, date)
	hourValue := parsedTime.Hour()

	return hourValue >= 12 && hourValue <= 18
}

// Description returns a formatted string of the appointment time.
func Description(date string) string {
	parsedDate := Schedule(date)

  return fmt.Sprintf("You have an appointment on %s", parsedDate.Format("Monday, January 2, 2006, at 15:04."))
}

// AnniversaryDate returns a Time with this year's anniversary.
func AnniversaryDate() time.Time {
  parsedAniversaryDate := Schedule("9/15/2012 00:00:00")
  yearsDifference := time.Since(parsedAniversaryDate).Hours()/24/365
	return parsedAniversaryDate.AddDate(int(yearsDifference) + 1, 0, 0)
}
