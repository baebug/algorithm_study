'''
기본 수학 1 - 설탕 배달

설탕 공장에서 설탕을 정확하게 N 킬로그램 배달해야 한다. (3kg, 5kg 두 종류의 봉지가 있다.)
N 킬로그램의 설탕을 배달해야 할 때, 최대한 적은 봉지를 가져가는 경우 봉지 수를 구하여라.
'''
import sys

def input():
    return sys.stdin.readline().strip()

def isDiv(n):
    a = n // 5
    b = n % 5

    if n == 1 or n == 2 or n == 4: return -1

    if b == 0:
        return a
    else:
        i = 0
        while a >= 0:
            if b % 3 == 0:
                i = b // 3
                return a + i
            else:
                b += 5
                a -= 1
        return -1

N = int(input())
print(isDiv(N))