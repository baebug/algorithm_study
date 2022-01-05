'''
1차원 배열 - 최댓값
'''
import sys

arr = []
for _ in range(9):
    n = int(sys.stdin.readline())
    arr.append(n)

max_n = max(arr)
idx_n = arr.index(max_n) + 1

print(max_n)
print(idx_n)