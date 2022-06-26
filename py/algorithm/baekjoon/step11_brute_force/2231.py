'''
브루트 포스 - 분해합

어떤 자연수 N 에 대하여, N 의 분해합은 N 과 N 을 이루는 각 자리수의 합을 의미한다.
M 의 분해합이 N 인 경우, M 을 N 의 생성자라 한다.
자연수 N 이 주어졌을 때, N 의 가장 작은 생성자를 구하는 프로그램을 작성하라.
'''
import sys

def input():
    return sys.stdin.readline().strip()

def solve(n):
    return n + sum(list(map(int, str(n))))

N = int(input())
ans = 0

for i in range(1, N + 1):
    if solve(i) == N:
        ans = i
        break

print(ans)