def check(mid, stones, k):
    count = 0
    for stone in stones:
        if stone < mid:
            count += 1
        else:
            count = 0
        if count == k:
            return False
    return True

def solution(stones, k):
    left, right = 1, max(stones)
    
    while left <= right:
        mid = (left + right) // 2
        if check(mid, stones, k):
            left = mid + 1
        else:
            right = mid - 1
            
    return right
