'''
가랏! RC카!
'''

import sys

input = sys.stdin.readline

t = int(input())

for test_case in range(1, t + 1):
    n = int(input())
    v = 0
    d = 0
    for i in range(n):
        command = list(map(int, input().split()))
        if command[0] == 0:
            pass
        elif command[0] == 1:
            v += command[1]
        else:
            if v >= command[1]:
                v -= command[1]
            else:
                v = 0
        d += v
    print(f'#{test_case} {d}')


