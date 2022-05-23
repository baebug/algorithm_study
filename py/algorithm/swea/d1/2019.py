'''
더블더블

input : 정수 N (N <= 30)

output : 1부터 주어진 횟수까지 2를 곱한 값(들)을 출력
'''

import sys

input = sys.stdin.readline

N = int(input())

for i in range(N + 1):
    print(2**i, end=" ")

