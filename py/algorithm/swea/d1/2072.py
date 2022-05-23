'''
홀수만 더하기
'''

import sys

input = sys.stdin.readline

T = int(input())
 
for test_case in range(1, T+1):
    sum = 0
    inputArr = map(int, input().split())
    for i in inputArr:
        if i & 1:
            sum += i
    print(f'#{test_case} {sum}')