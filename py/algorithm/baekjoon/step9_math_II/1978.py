'''
기본 수학 2 - 주어진 수 N 개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

N
A B C ... J (N개)
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
    
N = int(input())
nums = list(map(int, input().split()))
prime_list = [2]

ans = [1 for i in nums if isPrime(i)]
print(sum(ans))
