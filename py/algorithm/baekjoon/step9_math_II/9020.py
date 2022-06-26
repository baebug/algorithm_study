'''
기본 수학 2 - 골드바흐의 추측

2 보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다.
2 보다 큰 짝수 n 이 주어졌을 때, n 의 골드바흐 파티션을 출력하는 프로그램을 작성하라.
가능한 파티션이 여러 가지인 경우, 두 소수의 차이가 가장 작은 것을 출력한다.

input:
    T (테케 수)
    A (최소 4, 최대 10,000)
    B
    ...
    F
'''
import sys

def input():
    return sys.stdin.readline().strip()

li = [False, False] + [True for _ in range(9999)]

for i in range(2, 101):
    if li[i]:
        for j in range(i*2, 10001, i):
            li[j] = False

# num을 절반으로 나눠
# 가장 가까운 소수(p1)를 찾아
# num - p1 이 소수인지 확인해
# 맞을때까지 반복해

t = int(input())

for _ in range(t):
    num = int(input())
    for i, b in enumerate(li[num//2::-1]):
        if b:
            p1 = num//2 - i
            p2 = num - p1
            if li[p2]:
                print(p1, p2)
                break