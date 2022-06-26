'''
기본 수학 1 - 벌집

어려운데?
01
02 03 04 05 06 07 (6)
08 09 10 11 12 13 14 15 16 17 18 19 (12) (18) ...

'''
import sys

def input():
    return sys.stdin.readline().strip()

N = int(input())
cnt = 0


if N == 1:
    print(1)
else:
    while N - 1 > 0:
        N -= 6 * cnt
        cnt += 1
    print(cnt)