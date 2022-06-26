'''
기본 수학 2 - 소수 구하기

M 이상 N 이하의 소수를 모두 출력하는 프로그램을 작성하라.

input:
    M N (최대 1,000,000)
'''
import sys

def input():
    return sys.stdin.readline().strip()

M, N = list(map(int, input().split()))

eratos = [False, False] + [True for _ in range(N - 1)]

for i in range(2, int(N ** 0.5) + 1):    # 2 부터 1000 까지의 배수들 제거
    if eratos[i]:
        for j in range(i * 2, N + 1, i):
            eratos[j] = False


for i in range(M, N + 1):
    if eratos[i]:
        print(i)
