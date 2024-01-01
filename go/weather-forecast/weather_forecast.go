// Package weather provides tools to calculate the weather in any  city of goblinocus.
package weather

// CurrentCondition represents the current weather condition of a specific city.
var CurrentCondition string
// CurrentLocation represents the current city.
var CurrentLocation string

// Forecast returns a string informing the current weather condition to the current city.
func Forecast(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}
