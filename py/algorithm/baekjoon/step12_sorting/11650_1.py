'''
정렬 - 좌표 정렬하기

2차원 평면 위의 점 N 개가 주어진다. 좌표를 x 좌표가 증가하는 순으로, x 좌표가 같으면 y 좌표가 증가하는 순서로 정렬하여 출력하라.
'''
import sys

input = sys.stdin.readline

N = int(input())
li = []

for i in range(N):
    li.append(list(map(int, input().split())))

li.sort()

for i in li:
    print(i[0], i[1])