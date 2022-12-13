use std::collections::HashMap;

struct Team {
    name: String,
    mp: usize,
    w: usize,
    d: usize,
    l: usize,
    p: usize
}

impl Team {
    fn add_victory(&mut self) {
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
    let mut output = build_line("Team".to_string(), "MP".to_string(), "W".to_string(), "D".to_string(), "L".to_string(), "P".to_string());
    let mut table: Vec<Team> = Vec::new();
    
    let matches: Vec<&str> = match_results.split('\n').collect::<Vec<&str>>();
    for m in matches.iter() {
        let s = m.split(';').collect::<Vec<&str>>();
        let (name_a, name_b, result): (String, String, &str) = (s[0].to_string(), s[1].to_string(), s[1]);

        match table.iter().find(|x| x.name == name_a) {
            None => table.push(build_team(name_a)),
            _ => ()
        }

        match table.iter().find(|x| x.name == name_b) {
            None => table.push(build_team(name_b)),
            _ => ()
        }
    }

    output
}

fn build_team(name: String) -> Team {
    Team {
        name: name,
        mp: 0,
        w: 0,
        d: 0,
        l: 0,
        p: 0
    }
}

fn build_line(t: String, mp: String, w: String, d: String, l: String, p: String) -> String {
    format!("{:<31}| {:>2} | {:>2} | {:>2} | {:>2} | {:>2}", t, mp, w, d, l, p).to_string()
}
