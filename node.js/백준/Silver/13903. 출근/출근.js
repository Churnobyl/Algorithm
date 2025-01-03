let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");
// let input = fs.readFileSync("input.txt").toString().split("\r\n");
let inputIdx = 0;

const [R, C] = input[inputIdx++].split(" ").map(Number);
const map = Array.from({ length: R }, (_, i) =>
  input[inputIdx++].split(" ").map(Number)
);
const dp = Array.from({ length: R }, () => new Array(C).fill(Infinity));
const visited = Array.from({ length: R }, () => new Array(C).fill(false));
const N = Number(input[inputIdx++]);
const moves = Array.from({ length: N }, () =>
  input[inputIdx++].split(" ").map(Number)
);

let queue = [];
for (let j = 0; j < C; j++) {
  if (map[0][j] === 1) {
    dp[0][j] = 0;
    visited[0][j] = true;
    queue.push([0, j]);
  }
}

const isInBounds = (y, x) => y >= 0 && y < R && x >= 0 && x < C;

let result = Infinity;

while (queue.length) {
  let temp = [];

  for (let next of queue) {
    const [y, x] = next;

    for (const [dy, dx] of moves) {
      const ny = y + dy;
      const nx = x + dx;

      if (isInBounds(ny, nx) && map[ny][nx] === 1 && !visited[ny][nx]) {
        visited[ny][nx] = true;
        dp[ny][nx] = dp[y][x] + 1;
        if (ny === R - 1) {
          result = Math.min(result, dp[ny][nx]);
        } else {
          temp.push([ny, nx]);
        }
      }
    }
  }
  queue = temp;
}

console.log(result === Infinity ? -1 : result);
