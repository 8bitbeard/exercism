package lasagna

const (
	defaultAveragePrepTimePerLayer = 2
	noodleGramsPerLayer            = 50
	sauceLitersPerLayer            = 0.2
	defautPortionServe             = 2
)

func PreparationTime(layers []string, avgPrepTime int) int {
	if avgPrepTime == 0 {
		avgPrepTime = defaultAveragePrepTimePerLayer
	}
	return len(layers) * avgPrepTime
}

func Quantities(layers []string) (int, float64) {
	var noodleGrams int
	var sauceLiters float64
	for _, layer := range layers {
		switch layer {
		case "noodles":
			noodleGrams += noodleGramsPerLayer
		case "sauce":
			sauceLiters += sauceLitersPerLayer
		default:
			continue
		}
	}
	return noodleGrams, sauceLiters
}

func AddSecretIngredient(friendList, ownList []string) {
	specialIngredient := friendList[len(friendList)-1]
	ownList[len(ownList)-1] = specialIngredient
}

func ScaleRecipe(quantities []float64, portions int) []float64 {
	scaledQuantities := make([]float64, len(quantities))
	for index, amount := range quantities {
		scaledQuantities[index] = float64(portions) * amount / defautPortionServe
	}
	return scaledQuantities
}
