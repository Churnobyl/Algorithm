import heapq
import sys

V, E = map(int, sys.stdin.readline().rstrip().split())
K = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(V + 1)]
distances = [float('inf')] * (V + 1)

for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().rstrip().split())
    graph[u].append((v, w))

def dijkstra(start):
    q = [(0, start)]
    distances[start] = 0
    while q:
        dist, node = heapq.heappop(q)
        if distances[node] < dist:
            continue
        for next_node, weight in graph[node]:
            new_dist = dist + weight
            if new_dist < distances[next_node]:
                distances[next_node] = new_dist
                heapq.heappush(q, (new_dist, next_node))

dijkstra(K)

for distance in distances[1:]:
    print(distance if distance != float('inf') else "INF")