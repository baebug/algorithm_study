'''
아주 간단한 계산기

input : 자연수 a, b

output : 사칙연산 수행 결과
'''

from math import floor
import sys

input = sys.stdin.readline

a, b = map(int, input().split())

print(a + b)
print(a - b)
print(a * b)
print(floor(a / b))