'''
재귀 - 하노이 탑 이동 순서

원판의 수 n 이 주어진다.
'''
import sys

def input():
    return sys.stdin.readline().strip()

myCache = {}

def hanoi(n, start, end):
    other = 6 - (start + end)
    if n == 1:
        return str(start) + " " + str(end)
    if (n, start, end) in myCache:
        return myCache[(n, start, end)]
    
    tmp = [hanoi(n - 1, start, other), str(start) + " " + str(end), hanoi(n - 1, other, end)]
    myCache[(n, start, end)] = '\n'.join(tmp)
    return myCache[(n, start, end)]

n = int(input())

print(2 ** n - 1)
print(hanoi(n, 1, 3))