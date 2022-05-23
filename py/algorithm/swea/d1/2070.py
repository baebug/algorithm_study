'''
큰 놈, 작은 놈, 같은 놈
'''

import sys

input = sys.stdin.readline

T = int(input())

for test_case in range(1, T + 1):
    m, n = map(int, input().split())
    result = ''

    if m == n:
        result = '='
    elif m > n:
        result = '>'
    else:
        result = '<'

    print(f'#{test_case} {result}')