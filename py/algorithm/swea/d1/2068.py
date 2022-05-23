'''
최대수 구하기
'''

import sys

input = sys.stdin.readline

T = int(input())

for test_case in range(1, T + 1):
    inputArr = map(int, input().split())
    print(f'#{test_case} {max(inputArr)}')