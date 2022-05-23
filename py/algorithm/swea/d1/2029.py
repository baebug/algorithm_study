'''
몫과 나머지 출력하기

input1 : 테케 수 T
input : a, b

output : a 를 b 로 나눈 몫과 나머지
'''

import sys

input = sys.stdin.readline

T = int(input())

for test_case in range(1, T + 1):
    a, b = map(int, input().split())
    print(f'#{test_case} {a//b} {a%b}')