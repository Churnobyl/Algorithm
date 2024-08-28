import sys
a = []
for _ in range(5):
    a.append(list(sys.stdin.readline().rstrip()))

max_len = 0
for maxi in a:
    max_len = max(max_len, len(maxi))

for i in range(max_len):
    for j in range(5):
        try:
            print(a[j][i], end="")
        except:
            pass