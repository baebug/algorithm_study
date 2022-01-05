# 그냥 input() 대신 sys.stdin.readline() 을 써주면 되는 간단한 문제
# 대신 int 가 아닌 문자열을 받을 때 strip() 을 잘 활용해야 한다.

import sys

n = int(sys.stdin.readline())

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    print(a + b)