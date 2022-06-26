'''
정렬 - 수 정렬하기 2
'''
import sys

def input():
    return sys.stdin.readline().strip()

N = int(input())
arr = []

for _ in range(N):
    arr.append(int(input()))

arr.sort()

for i in arr:
    print(i)