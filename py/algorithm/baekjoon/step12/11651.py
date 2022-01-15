'''
정렬 - 좌표 정렬하기 2

점 N 개가 주어진다. 좌표를 y 좌표가 증가하는 순으로, y 좌표가 같으면 x 좌표가 증가하는 순서로 정렬한 다음 출력하라.
'''
import sys

input = sys.stdin.readline

N = int(input())
li = [input() for _ in range(N)]

li.sort(key=lambda x: int(x.split()[0]))    # x 좌표로 먼저 정렬한 다음
li.sort(key=lambda x: int(x.split()[1]))    # y 좌표로 정렬한다.

print(''.join(li))