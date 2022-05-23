'''
거꾸로 출력해 보아요

input : 정수 N

output : N 부터 0 까지 출력
'''

import sys

input = sys.stdin.readline

N = int(input())

arr = [i for i in range(N, -1, -1)]

print(*arr)