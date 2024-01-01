use std::{collections::HashMap, hash::Hash};

pub fn count(nucleotide: char, dna: &str) -> Result<usize, char> {
    if ['A', 'C', 'G', 'T'].contains(&nucleotide) {
        let mut counter: usize = 0;
        for c in dna.chars() {
            match c {
                x if x == nucleotide => counter += 1,
                'A' | 'C' | 'G' | 'T' => (),
                x => return Err(x)
            }
        }
        return Ok(counter)
    }
    Err(nucleotide)
}

pub fn nucleotide_counts(dna: &str) -> Result<HashMap<char, usize>, char> {
    unimplemented!(
        "How much of every nucleotide type is contained inside DNA string '{}'?",
        dna
    );
}
