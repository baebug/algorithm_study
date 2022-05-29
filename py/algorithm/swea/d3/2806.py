'''
N-Queen
'''


def is_promising(x):
    for i in range(x):
        if board[i] == board[x] or abs(board[x] - board[i]) == abs(x - i):
            return False

    return True


def n_queen(x):
    global cnt
    if x == n:
        cnt += 1
        return
    else:
        for i in range(n):
            board[x] = i
            if is_promising(x):
                n_queen(x+1)


t = int(input())

for test_case in range(1, t+1):
    n = int(input())
    board = [0] * n
    cnt = 0

    n_queen(0)

    print(f'#{test_case} {cnt}')
