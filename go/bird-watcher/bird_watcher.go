package birdwatcher

// TotalBirdCount return the total bird count by summing
// the individual day's counts.
func TotalBirdCount(birdsPerDay []int) int {
	var totalCount int
	for _, birdCount := range birdsPerDay {
		totalCount += birdCount
	}
	return totalCount
}

// BirdsInWeek returns the total bird count by summing
// only the items belonging to the given week.
func BirdsInWeek(birdsPerDay []int, week int) int {
	weekSlice := birdsPerDay[(week-1)*7 : week*7]
	return TotalBirdCount(weekSlice)
}

// FixBirdCountLog returns the bird counts after correcting
// the bird counts for alternate days.
func FixBirdCountLog(birdsPerDay []int) []int {
	for index := range birdsPerDay {
		if index%2 == 0 {
			birdsPerDay[index]++
		}
	}
	return birdsPerDay
}
