pub struct Allergies {
    allergies: Vec<Allergen>
}

#[derive(Clone, Copy, Debug, PartialEq, Eq)]
pub enum Allergen {
    Eggs,
    Peanuts,
    Shellfish,
    Strawberries,
    Tomatoes,
    Chocolate,
    Pollen,
    Cats,
}

impl Allergies {
    pub fn new(score: u32) -> Self {
        let binary = format!("{:b}", score);
        let chars = binary.chars().rev();
        let mut al: Vec<Allergen> = Vec::new();
        
        for (i, c) in chars.enumerate() {
            match c.to_digit(10_u32).unwrap() * 2_u32.pow(i as u32) {
                1 => al.push(Allergen::Eggs),
                2 => al.push(Allergen::Peanuts),
                4 => al.push(Allergen::Shellfish),
                8 => al.push(Allergen::Strawberries),
                16 => al.push(Allergen::Tomatoes),
                32 => al.push(Allergen::Chocolate),
                64 => al.push(Allergen::Pollen),
                128 => al.push(Allergen::Cats),
                _=> ()
            }
        }

        Allergies {allergies: al}
    }

    pub fn is_allergic_to(&self, allergen: &Allergen) -> bool {
        self.allergies.contains(allergen)
    }

    pub fn allergies(&self) -> Vec<Allergen> {
        self.allergies.clone()
    }
}
