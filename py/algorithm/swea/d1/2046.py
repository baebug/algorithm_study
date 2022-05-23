'''
스탬프 찍기

input : 자연수 N (100,000 이하)
output : N개의 #
'''

import sys

input = sys.stdin.readline

N = int(input())

print('#' * N)