#[derive(Debug)]
pub enum CalculatorInput {
    Add,
    Subtract,
    Multiply,
    Divide,
    Value(i32),
}

pub fn evaluate(inputs: &[CalculatorInput]) -> Option<i32> {
    let mut stack: Vec<i32> = Vec::new();

    for i in inputs.iter() {
        match i {
            CalculatorInput::Value(x) => stack.push(*x),
            _ if stack.len() >= 2 => operation(&mut stack, i),
            _ => return None
        }
    }
    
    if stack.len() != 1 {
        return None
    }
    
    Some(stack[0])
}

fn operation(stack: &mut Vec<i32>, operation: &CalculatorInput) {
    let b = stack.pop().unwrap();
    let a = stack.pop().unwrap();
    match operation {
        CalculatorInput::Add => stack.push(a + b),
        CalculatorInput::Subtract => stack.push(a - b),
        CalculatorInput::Multiply => stack.push(a * b),
        CalculatorInput::Divide => stack.push(a / b),
        _ => ()
    }
}
