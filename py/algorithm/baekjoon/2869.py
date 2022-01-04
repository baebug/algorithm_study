'''
기본 수학 1 - 달팽이는 올라가고 싶다

땅 위의 달팽이가 높이 V 미터인 나무 막대를 올라갈 것이다.
낮에 A 미터 올라가고, 밤에 B 미터 미끄러진다. 정상에 올라서면 미끄러지지 않는다.
나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하라.

input: A B V
'''
import sys
import math

def input():
    return sys.stdin.readline().strip()

A, B, V = list(map(int, input().split()))

if A >= V:
    print(1)
else:
    day = math.ceil((V - A) / (A - B))
    print(day + 1)
