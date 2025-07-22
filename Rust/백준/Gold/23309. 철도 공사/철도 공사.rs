use std::io::{self, BufRead, BufWriter, Write};

#[derive(Clone)]
struct Node {
    #[allow(dead_code)]
    id: usize,
    prev: usize,
    next: usize,
}

fn main() {
    let stdin = io::stdin();
    let mut input = String::new();
    let mut reader = stdin.lock();

    reader.read_line(&mut input).unwrap();
    let mut it = input.split_ascii_whitespace();
    let n: usize = it.next().unwrap().parse().unwrap();
    let m: usize = it.next().unwrap().parse().unwrap();

    input.clear();
    reader.read_line(&mut input).unwrap();
    let init_ids: Vec<usize> = input
        .split_ascii_whitespace()
        .map(|x| x.parse().unwrap())
        .collect();

    let mut nodes = vec![None; 1_000_001];
    for i in 0..n {
        let id = init_ids[i];
        let prev = init_ids[(i + n - 1) % n];
        let next = init_ids[(i + 1) % n];
        nodes[id] = Some(Node { id, prev, next });
    }

    let mut output = BufWriter::new(io::stdout());
    let mut buffer = String::new();

    for _ in 0..m {
        buffer.clear();
        reader.read_line(&mut buffer).unwrap();
        let mut cmd = buffer.split_ascii_whitespace();

        match cmd.next().unwrap() {
            "BN" => {
                let id: usize = cmd.next().unwrap().parse().unwrap();
                let new_id: usize = cmd.next().unwrap().parse().unwrap();

                if let Some(cur) = nodes[id].as_ref() {
                    let next = cur.next;
                    writeln!(output, "{}", next).unwrap();

                    if nodes[new_id].is_none() {
                        nodes[new_id] = Some(Node {
                            id: new_id,
                            prev: id,
                            next,
                        });
                        nodes[id].as_mut().unwrap().next = new_id;
                        nodes[next].as_mut().unwrap().prev = new_id;
                    }
                }
            }
            "BP" => {
                let id: usize = cmd.next().unwrap().parse().unwrap();
                let new_id: usize = cmd.next().unwrap().parse().unwrap();

                if let Some(cur) = nodes[id].as_ref() {
                    let prev = cur.prev;
                    writeln!(output, "{}", prev).unwrap();

                    if nodes[new_id].is_none() {
                        nodes[new_id] = Some(Node {
                            id: new_id,
                            prev,
                            next: id,
                        });
                        nodes[prev].as_mut().unwrap().next = new_id;
                        nodes[id].as_mut().unwrap().prev = new_id;
                    }
                }
            }
            "CN" => {
                let id: usize = cmd.next().unwrap().parse().unwrap();

                if let Some(cur) = nodes[id].as_ref() {
                    let target = cur.next;
                    if let Some(target_node) = nodes[target].as_ref() {
                        let next = target_node.next;
                        writeln!(output, "{}", target).unwrap();

                        nodes[id].as_mut().unwrap().next = next;
                        nodes[next].as_mut().unwrap().prev = id;
                        nodes[target] = None;
                    }
                }
            }
            "CP" => {
                let id: usize = cmd.next().unwrap().parse().unwrap();

                if let Some(cur) = nodes[id].as_ref() {
                    let target = cur.prev;
                    if let Some(target_node) = nodes[target].as_ref() {
                        let prev = target_node.prev;
                        writeln!(output, "{}", target).unwrap();

                        nodes[id].as_mut().unwrap().prev = prev;
                        nodes[prev].as_mut().unwrap().next = id;
                        nodes[target] = None;
                    }
                }
            }
            _ => unreachable!(),
        }
    }
}
