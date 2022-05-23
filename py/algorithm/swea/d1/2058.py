'''
자릿수 더하기

input1 : 자연수 N
'''

import sys

input = sys.stdin.readline

N = input()
sum = 0

for i in N:
    sum += int(i)

print(sum)