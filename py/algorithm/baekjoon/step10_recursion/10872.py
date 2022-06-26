'''
재귀 - 팩토리얼

0 보다 크거나 같은 정수 N 이 주어진다. 이때, N! 을 출력하는 프로그램을 작성하라.
'''
import sys

def input():
    return sys.stdin.readline().strip()

N = int(input())

def fac(n):
    if n <= 1: return 1
    
    return n * fac(n - 1)

print(fac(N))