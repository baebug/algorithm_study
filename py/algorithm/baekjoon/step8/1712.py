'''
기본 수학 1 - 손익분기점

고정 비용 A, 노트북 대 당 B
노트북 가격이 C로 책정 되었을 때, 손익분기점을 구하여라. (없으면 -1)
'''
import sys
import math

def input():
    return sys.stdin.readline().strip()

A, B, C = list(map(int, input().split()))

if (C - B) <= 0:
    print(-1)
else:
    print(math.floor((A / (C - B) + 1)))
