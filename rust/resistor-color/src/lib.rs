use int_enum::IntEnum;

#[repr(u32)]
#[derive(Clone, Copy, Debug, PartialEq, Eq, IntEnum)]
pub enum ResistorColor {
    Black = 0,
    Blue = 6,
    Brown = 1,
    Green = 5,
    Grey = 8,
    Orange = 3,
    Red = 2,
    Violet = 7,
    White = 9,
    Yellow = 4,
}

impl std::fmt::Display for ResistorColor {
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        match self {
            ResistorColor::Black => write!(f, "Black"),
            ResistorColor::Blue => write!(f, "Blue"),
            ResistorColor::Brown => write!(f, "Brown"),
            ResistorColor::Green => write!(f, "Green"),
            ResistorColor::Grey => write!(f, "Grey"),
            ResistorColor::Orange => write!(f, "Orange"),
            ResistorColor::Red => write!(f, "Red"),
            ResistorColor::Violet => write!(f, "Violet"),
            ResistorColor::White => write!(f, "White"),
            ResistorColor::Yellow => write!(f, "Yellow"),
        }
    }
}

pub fn color_to_value(_color: ResistorColor) -> u32 {
    _color.int_value()
}

pub fn value_to_color_string(value: u32) -> String {
    match ResistorColor::from_int(value) {
        Ok(x) => x.to_string(),
        _ => "value out of range".to_string()
    }
}

pub fn colors() -> Vec<ResistorColor> {
    (0..=9).map(|x| ResistorColor::from_int(x).unwrap()).collect()
}
