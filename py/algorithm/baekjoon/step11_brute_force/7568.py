'''
브루트 포스 - 덩치

덩치 = (키, 몸무게)
키, 몸무게가 둘 다 크거나 작으면 덩치 등수가 높다. 구별할 수 없으면 동률이다.
덩치 등수를 계산해서 출력하라.

input:
    N
    x y (N개)
'''
import sys

def input():
    return sys.stdin.readline().strip()

N = int(input())

# 다 넣어두고, 한 명씩 자기보다 덩치 등수 낮은 사람 검색, 덩치 등수 + 1
li = []

for _ in range(N):
    x, y = map(int, input().split())
    li.append([x, y, 1])

for i in range(N):
    x = li[i][0]
    y = li[i][1]
    for j in range(N):
        if x > li[j][0] and y > li[j][1]:
            li[j][2] += 1

for i in range(N):
    print(li[i][2], end=" ")