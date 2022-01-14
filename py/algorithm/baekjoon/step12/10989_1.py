'''
정렬 - 수 정렬하기 3

카운팅 정렬 (수의 범위가 작을 때 효과적이다.)
'''
import sys

def input():
    return sys.stdin.readline().strip()

N = int(input())

li = []
ans = [-1] * N

for _ in range(N):
    num = int(input())
    li.append(num)

arr = [0] * (max(li) + 1)

for i in li:
    arr[i] += 1

for i in range(len(arr)-1):
    arr[i+1] += arr[i]

for i in li[::-1]:
    ans[arr[i]-1] = i
    arr[i] -= 1

for i in ans:
    print(i)