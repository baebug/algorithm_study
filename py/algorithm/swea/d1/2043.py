'''
서랍의 비밀번호

input : 세 자리 자연수 P, K
'''

import sys

input = sys.stdin.readline

P, K = map(int, input().split())

if P >= K:
    ans = P - K + 1
else: # P: 005, K = 998  ---  998 999 000 001 002 003 004 005
    ans = 999 - K + P + 2

print(ans)