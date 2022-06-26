'''
기본 수학 2 - 소수

M 과 N 이 주어질 때 M 이상, N 이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾아라.
input:
    M
    N
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


def solve(M, N):
    arr = list(range(M, N + 1))
    ans = []
    for i in arr:
        if isPrime(i): ans.append(i)
    
    if ans:
        print(sum(ans))
        print(min(ans))
    else:
        print(-1)


M = int(input())
N = int(input())
prime_list = [2]

solve(M, N)






