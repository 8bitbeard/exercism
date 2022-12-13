// This stub file contains items that aren't used yet; feel free to remove this module attribute
// to enable stricter warnings.
#![allow(unused)]

/// various log levels
#[derive(Clone, PartialEq, Eq, Debug)]
pub enum LogLevel {
    Info,
    Warning,
    Error,
}
/// primary function for emitting logs
pub fn log(level: LogLevel, message: &str) -> String {
    match level {
        LogLevel::Info => info(&message),
        LogLevel::Warning => warn(&message),
        LogLevel::Error => error(&message),
    }
}

pub fn info(message: &str) -> String {
    let mut owned_string = String::from("[INFO]: "); 
    owned_string.push_str(message);

    owned_string
}

pub fn warn(message: &str) -> String {    
    let mut owned_string = String::from("[WARNING]: "); 
    owned_string.push_str(message);

    owned_string
}

pub fn error(message: &str) -> String {    
    let mut owned_string = String::from("[ERROR]: ");
    owned_string.push_str(message);

    owned_string
}
