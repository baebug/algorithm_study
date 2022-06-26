'''
문자열 - 그룹 단어 체커

그룹 단어: 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
'''
import sys
from collections import deque

def input():
    return sys.stdin.readline().strip()

def isGroupWord(string):
    string = deque(string)
    checker = -1
    used = []

    while string:
        c = string.popleft()
        if checker != c:
            checker = c
            if not(c in used):
                used.append(c)
            else:
                return 0
        else:
            pass
    return 1

n = int(input())
cnt = 0

for _ in range(n):
    cnt += isGroupWord(input())

print(cnt)