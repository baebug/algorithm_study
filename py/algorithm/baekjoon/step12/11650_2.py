'''
정렬 - 좌표 정렬하기

2차원 평면 위의 점 N 개가 주어진다. 좌표를 x 좌표가 증가하는 순으로, x 좌표가 같으면 y 좌표가 증가하는 순서로 정렬하여 출력하라.
'''
import sys

input = sys.stdin.readline

N = int(input())
li = [input() for _ in range(N)]

li.sort(key=lambda x: int(x.split()[1]))    # y 좌표로 먼저 정렬한 다음
li.sort(key=lambda x: int(x.split()[0]))    # x 좌표로 정렬한다.

# 이런 방법도 있다.
# li.sort(key=lambda x: tuple(map(int, x.split())))   # tuple 이 list 보다 빠르다.

print(''.join(li))  # 개행문자까지 들어있어서 for 문 안돌리고 join 해도 된다.