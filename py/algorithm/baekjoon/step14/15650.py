'''
백트래킹 - N 과 M (2)

자연수 N 과 M 이 주어졌을 때, 아래 조건을 만족하는 길이가 M 인 수열을 모두 구하는 프로그램을 작성하라.
    - 1 부터 N 까지 자연수 중에서 중복 없이 M 개를 고른 수열
    - 고른 수열은 오름차순이어야 한다.

input:
    N M (1 ~ M ~ N ~ 8)
'''
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = []

def dfs():
    if len(arr) == m:
        print(' '.join(map(str, arr)))
        return

    for i in range(1, n+1):
        if not arr or i > arr[-1]:
            arr.append(i)
            dfs()
            arr.pop()
        
dfs()