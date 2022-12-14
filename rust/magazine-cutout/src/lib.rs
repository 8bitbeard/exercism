// This stub file contains items that aren't used yet; feel free to remove this module attribute
// to enable stricter warnings.
#![allow(unused)]

use std::collections::HashMap;

pub fn can_construct_note(magazine: &[&str], note: &[&str]) -> bool {
   let mut available_words: HashMap<&str, usize> = HashMap::new();

    for e in magazine.iter() {
        let w = available_words.entry(e).or_insert(0);
        *w += 1;
    }

    for e in note.iter() {
        match available_words.get_mut(e) {
            Some(x) if *x == 0 => return false,
            Some(x) => *x -= 1,
            None => return false
        }
    }

    return true
}
