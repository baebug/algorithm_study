'''
기본 수학 2 - 터렛

p1, p2의 좌표 (x1, y1), (x2, y2) 가 주어지고, 거리 r1 r2 가 주어졌을 때,
p3 가 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하라. (무한대일 경우 -1 출력)

input:
    T
    x1 y1 r1 x2 y2 r2
'''
import sys

def input():
    return sys.stdin.readline().strip()

t = int(input())

for _ in range(t):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())

    d = ((x1 - x2) ** 2 + (y1 - y2) ** 2) ** 0.5
    R = max(r1, r2)
    r = min(r1, r2)

    if d == 0:
        if R == r:
            print(-1)
        else:
            print(0)
    else:
        if R == d:
            print(2)
        elif R > d:
            if R > r + d:
                print(0)
            elif R == r + d:
                print(1)
            else:
                print(2)
        elif R < d:
            if d > R + r:
                print(0)
            elif d == R + r:
                print(1)
            elif d < R + r:
                print(2)

# 1. 큰 원이 작은 원을 포함 (1, 2)
#   max(r1, r2, d) != d (R > d)
#       d + min(r1, r2) >=< max(r1, r2)

# 2. 겹침 (-1)
#   d = 0
#       r1 == r2 (-1)
#       r1 != r2 (0)

# 3. 두 원이 나뉘어져 있음 (1, 2)
#   max(r1, r2, d) == d (R < d)
#       r1 + r2 >=< d