'''
브루트 포스 - 체스판 다시 칠하기

M x N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 이 보드를 잘라서 8 x 8 크기의 체스판으로 만들려고 한다.
다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하라.

input:
    N M (8 ~ 50)
    BWWBW..
        ...
            ..BW
'''
import sys

def input():
    return sys.stdin.readline().strip()

def isChess(n, m):
    chess = []
    tmp = board[n:n+8]
    for l in tmp:
        chess.append(l[m:m+8])
    # chess[0][0]이 W 여도 B 로 시작하는 경우가 더 효율적일 수 있다.
    return min(countChess(chess, "W"), countChess(chess, "B"))

def countChess(chess, init):
    cnt = 0
    for i in range(8):
        for j in range(8):
            if i&1 == 0:    # 짝수줄 (j 가 짝수면 init, 홀수면 != init)
                if j&1 == 0 and chess[i][j] != init:
                    cnt += 1
                elif j&1 == 1 and chess[i][j] == init:
                    cnt += 1
            elif i&1 == 1:  # 홀수줄 (j 가 홀수면 init, 짝수면 != init)
                if j&1 == 0 and chess[i][j] == init:
                    cnt += 1
                elif j&1 == 1 and chess[i][j] != init:
                    cnt += 1
    return cnt
    
N, M = map(int, input().split())    # 가로: M , 세로: N
board = []
ans = 64

for i in range(N):
    board.append(list(input()))

for n in range(N - 7):
    for m in range(M - 7):
        ans = min(ans, isChess(n, m))
    
print(ans)

                
            
