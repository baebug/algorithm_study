'''
기본 수학 2 - 소인수분해

정수 N 이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

# 시간초과 뜸
# n /= div 한 이후 n 이 소수인지 확인해야 함
# root(n) 보다 작은 소수로 안나눠지면 소수임
'''
import sys

def input():
    return sys.stdin.readline().strip()

def solve(n):
    div = 2
    while div * div <= n:
        if n % div == 0:
            print(div)
            n //= div
        else:
            div += 2 if div > 2 else 1
    if n > 1:
        print(n)

N = int(input())    
solve(N)
