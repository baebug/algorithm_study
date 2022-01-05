'''
1차원 배열 - 최소, 최대
'''
import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
max_arr = max(arr)
min_arr = min(arr)
print(min_arr, max_arr)