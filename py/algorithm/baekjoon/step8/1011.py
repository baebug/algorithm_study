'''
기본 수학 1 - Fly me to the Alpha Centauri

이동거리 -1 , - , +1 만 가능하다.
출발 지점과 목표 지점의 좌표가 주어질 때, 최소한의 이동 횟수를 구하여라. (도착 직전에는 반드시 1로 이동해야 한다.)

이동 횟수 별 최대 거리를 구할 수 있다. (홀 / 짝 으로 나뉨)
그걸 역으로 계산하면 된다.
'''
import sys
import math

def input():
    return sys.stdin.readline().strip()

# 이동 횟수가 주어졌을 때 최대 이동거리
def max_d(n):
    if n&1: # n 이 홀수면
        return ((n + 1) // 2)**2
    else:
        a = n // 2
        return a * (a + 1)

def dist(start, end):
    d = end - start
    sqr_d = math.sqrt(d)

    if sqr_d % 1 == 0:
        return int(2 * sqr_d - 1)
    else:
        fsqr_d = int(math.floor(sqr_d))
        tmp = max_d(2 * fsqr_d)
        if d > tmp:
            return 2 * fsqr_d + 1
        return 2 * fsqr_d

t = int(input())

for _ in range(t):
    start, end = list(map(int, input().split()))
    print(dist(start, end))