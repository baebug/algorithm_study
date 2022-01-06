'''
기본 수학 2 - 소인수분해

정수 N 이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

# 시간초과 뜸
'''
import sys

def input():
    return sys.stdin.readline().strip()


def isPrime(n):
    if n in prime_list: return True

    if n == 1: return False
    elif n == 2: return True

    div = 2
    while n > div:
        if n % div == 0:
            return False
        else:
            div += 1
    prime_list.append(n)
    return True

def solve(n):
    div = 2
    while n != 1:
        if n % div == 0:
            n = n // div
            print(div)
        else:
            while 1:
                div += 1
                if isPrime(div): break

prime_list = [2]
N = int(input())
solve(N)

