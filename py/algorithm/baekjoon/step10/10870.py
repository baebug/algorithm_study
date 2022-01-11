'''
재귀 - 피보나치 수 5

n 이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오. 

input:
    n   (0 ~ 20)
'''
import sys

def input():
    return sys.stdin.readline().strip()

def fib(n):
    if n == 0: return 0
    if n == 1: return 1

    return fib(n - 1) + fib(n - 2)

n = int(input())

print(fib(n))