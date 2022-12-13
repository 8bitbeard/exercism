// This stub file contains items that aren't used yet; feel free to remove this module attribute
// to enable stricter warnings.
#![allow(unused)]

pub fn production_rate_per_hour(speed: u8) -> f64 {
    let cars_times_speed: f64 = (speed as u32 * 221) as f64;
    
    if speed < 5 {
        return cars_times_speed;
    } else if speed < 9 {
        return cars_times_speed * 0.9;
    } else {
        return cars_times_speed * 0.77; 
    }
}

pub fn working_items_per_minute(speed: u8) -> u32 {
    return (production_rate_per_hour(speed) as u32) / 60
}
