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
        if !w.is_empty() {
            *word_count.entry(e).or_insert(0) += 1;
        }
    }

    word_count
}

fn parse_word(word: String) -> String {
    let mut parsed_word = word
        .trim()
        .chars()
        .filter(|x|
            ('a'..='z').contains(x)
            || ('A'..='Z').contains(x)
            || ('0'..='9').contains(x)
            || *x == '\'')
        .collect::<String>().to_lowercase();

    if parsed_word.chars().filter(|x| *x == '\'').count() > 1 {
        let l = parsed_word.chars().count();
        parsed_word = parsed_word[1..l-1].to_string()
    }

    parsed_word
}
