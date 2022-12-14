// This stub file contains items that aren't used yet; feel free to remove this module attribute
// to enable stricter warnings.
#![allow(unused)]

pub struct Player {
    pub health: u32,
    pub mana: Option<u32>,
    pub level: u32,
}

impl Player {
    pub fn revive(&self) -> Option<Player> {
        if self.health == 0 {
            let mana = if self.level >= 10 { Some(100) } else { None };
            Some(Player {
                health: 100,
                mana,
                level: self.level,
            })
        } else {
            None
        }
    }

    pub fn cast_spell(&mut self, mana_cost: u32) -> u32 {
        match self.mana {
            Some(x) if x >= mana_cost => {
                self.mana = Some(x - mana_cost);
                mana_cost * 2
            }
            Some(x) => 0,
            _ => {
                self.health -= if mana_cost > self.health {
                    self.health
                } else {
                    mana_cost
                };
                0
            }
        }
    }
}
