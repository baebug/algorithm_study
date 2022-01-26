'''
백트래킹 - N Queen

N x N 인 체스판 위에 퀸 N 개를 서로 공격할 수 없게 놓는 문제이다.
N 이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하라.

input:
    N (1 ~ 14)
'''
import sys
import copy


input = sys.stdin.readline

def pos(r, c, arr):
    # arr[row][column] 에 queen 을 두면, 그 퀸이 공격할 수 있는 공간을 False 로 바꾼다.
    n = len(arr)
    tmp = copy.deepcopy(arr)
    for i in range(n):   # 0, 1, 2, ..., n-1
        if i != r:
            tmp[i][c] = False
        if i != c:
            tmp[r][i] = False
        if r + i < n:
            if c + i < n:
                tmp[r+i][c+i] = False
            if c - i >= 0:
                tmp[r+i][c-i] = False
        if r - i >= 0:
            if c + i < n:
                tmp[r-i][c+i] = False
            if c - i >= 0:
                tmp[r-i][c-i] = False
    return tmp

def dfs(arr):
    depth = len(ans)
    if depth == n:
        print("success")
        return
    
    if True in arr[depth]:
        for j in range(n):
            if arr[depth][j]:
                ans.append([depth, j])
                tmp = pos(depth, j, arr)
                print(tmp)
                dfs(tmp)
    else:
        if ans:
            ans.pop()
        dfs(arr)

n = int(input())
arr = [[True for _ in range(n)] for _ in range(n)]
ans = []
cnt = 0

dfs(arr)
