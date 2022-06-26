'''
기본 수학 2 - 네 번째 점

세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하라.

input:
    x1 y1
    x2 y2
    x3 y3
'''
import sys

def input():
    return sys.stdin.readline().strip()

x1, y1 = map(int, input().split())
x2, y2 = map(int, input().split())
x3, y3 = map(int, input().split())

arr_x = [x1, x2, x3]
arr_y = [y1, y2, y3]

if arr_x.count(min(arr_x)) == 1:
    x4 = min(arr_x)
else:
    x4 = max(arr_x)

if arr_y.count(min(arr_y)) == 1:
    y4 = min(arr_y)
else:
    y4 = max(arr_y)

print(x4, y4)