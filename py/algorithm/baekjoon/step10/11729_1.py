'''
재귀 - 하노이 탑 이동 순서

원판의 수 n 이 주어진다.
'''
import sys

def input():
    return sys.stdin.readline().strip()

def hanoi(n, start, end):
    other = 6 - (start + end)
    if n == 1:
        print(start, end)
    else:
        hanoi(n - 1, start, other)
        print(start, end)
        hanoi(n - 1, other, end)

n = int(input())

print(2 ** n - 1)
hanoi(n, 1, 3)