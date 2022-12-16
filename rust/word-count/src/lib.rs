use std::collections::HashMap;

/// Count occurrences of words.
pub fn word_count(words: &str) -> HashMap<String, u32> {
    let mut word_count: HashMap<String, u32> = HashMap::new();

    let words = words
        .split(&[',', ' ', '\n'])
        .map(|x| parse_word(x.to_string()))
        .collect::<Vec<String>>();

    for w in words.iter() {
        let e = w.to_string();
        if e.chars().all(|x| x.is_alphanumeric()) {
            *word_count.entry(e).or_insert(0) += 1;
        }
    }

    word_count
}

fn parse_word(word: String) -> String {
    let word = word.trim();
    word.to_string()
}
