'''
기본 수학 2 - 택시 기하학

택시 기하학에서 두 점 T1(x1, y1), T2(x2, y2) 사이의 거리는 다음과 같다.
D(T1, T2) = |x1 - x2| + |y1 - y2|
반지름 R 이 주어졌을 때,
유클리드 기하학에서 원의 넓이와, 택시 기하학에서 원의 넓이를 구하는 프로그램을 작성하라.

input:
    r (반지름)
'''
import sys
import math

def input():
    return sys.stdin.readline().strip()

r = int(input())

print('{0:0.6f}'.format(math.pi * r ** 2))
print('{0:0.6f}'.format(2 * r ** 2))


