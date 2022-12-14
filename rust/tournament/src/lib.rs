use std::collections::HashMap;

const HEADER: &str = "Team                           | MP |  W |  D |  L |  P\n";

struct TeamResults {
    mp: usize,
    w: usize,
    d: usize,
    l: usize,
    p: usize,
}

impl TeamResults {
    fn new() -> Self {
        TeamResults {
            mp: 0,
            w: 0,
            d: 0,
            l: 0,
            p: 0,
        }
    }

    fn add_win(&mut self) {
        self.mp += 1;
        self.w += 1;
        self.p += 3;
    }

    fn add_draw(&mut self) {
        self.mp += 1;
        self.d += 1;
        self.p += 1;
    }

    fn add_loss(&mut self) {
        self.mp += 1;
        self.l += 1;
    }
}

pub fn tally(match_results: &str) -> String {
    let mut output = HEADER.to_string();

    let mut table: HashMap<String, TeamResults> = HashMap::new();

    let matches: Vec<&str> = match_results.split('\n').collect::<Vec<&str>>();

    for m in matches.iter() {
        match m {
            &"" => (),
            _ => {
                let s = m.split(';').collect::<Vec<&str>>();

                let (name_a, name_b, result): (String, String, &str) =
                    (s[0].to_string(), s[1].to_string(), s[2]);

                match result {
                    "win" => {
                        table.entry(name_a).or_insert(TeamResults::new()).add_win();
                        table.entry(name_b).or_insert(TeamResults::new()).add_loss();
                    }

                    "loss" => {
                        table.entry(name_a).or_insert(TeamResults::new()).add_loss();
                        table.entry(name_b).or_insert(TeamResults::new()).add_win();
                    }

                    _ => {
                        table.entry(name_a).or_insert(TeamResults::new()).add_draw();
                        table.entry(name_b).or_insert(TeamResults::new()).add_draw();
                    }
                }
            }
        }
    }

    let mut hash_vec: Vec<(&String, &TeamResults)> = table.iter().collect();

    hash_vec.sort_by(|a, b| {
        if b.1.p == a.1.p {
            a.0.cmp(&b.0)
        } else {
            b.1.p.cmp(&a.1.p)
        }
    });

    for e in hash_vec.iter() {
        let name = e.0;
        let results = e.1;

        output += &format!(
            "{:<31}| {:>2} | {:>2} | {:>2} | {:>2} | {:>2}\n",
            name, results.mp, results.w, results.d, results.l, results.p
        );
    }

    output.trim().to_string()
}
