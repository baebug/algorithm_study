'''
기본 수학 2 - 직사각형에서 탈출

한수의 위치 (x, y)  직사각형은 왼쪽 아래 꼭짓점이 (0, 0) 오른쪽 위 (w, h)
직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하라.

input:
    x y w h
'''
import sys

def input():
    return sys.stdin.readline().strip()

x, y, w, h = map(int, input().split())

ans = min(x, y, w - x, h - y)

print(ans)