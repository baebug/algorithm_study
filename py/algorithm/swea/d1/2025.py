'''
N줄 덧셈

input : 자연수 N (N <= 10,000)

output : 1 부터 N 까지의 합
'''

import sys

input = sys.stdin.readline

N = int(input())

print(sum(range(1, N+1)))