'''
정렬 - 수 정렬하기

N 개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

input:
    N
    a
    b
    ...
    n
'''
import sys

def input():
    return sys.stdin.readline().strip()

N = int(input())

arr = []

for _ in range(N):
    arr.append(int(input()))

for i in range(N-1):
    for j in range(i+1, N):
        if arr[i] > arr[j]:
            arr[i], arr[j] = arr[j], arr[i]
            
for i in arr:
    print(i)