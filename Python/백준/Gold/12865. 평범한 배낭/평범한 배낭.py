import sys

N, K = map(int, sys.stdin.readline().rstrip().split())
items = [(0, 0)] + [tuple(map(int, sys.stdin.readline().rstrip().split()))
                    for _ in range(N)]
dp = [[0 for _ in range(K + 1)] for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, K + 1):
        w, v = items[i]
        if j < w:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + v)
print(dp[N][K])