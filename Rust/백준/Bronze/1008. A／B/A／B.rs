use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("msg");

    let nums: Vec<f64> = input
        .trim()
        .split_whitespace()
        .map(|s| s.parse().expect("not number"))
        .collect();

    println!("{:.15}", nums[0] / nums[1]);
}
