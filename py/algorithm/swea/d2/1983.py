'''
조교의 성적 매기기
'''

import math


def solve():
    grade = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
    t = int(input())

    for test_case in range(1, t + 1):
        n, k = map(int, input().split())
        board = {}
        for i in range(n):
            a, b, c = map(int, input().split())
            score = .35 * a + .45 * b + .2 * c
            board[i+1] = score

        board = sorted(board.items(), key=lambda s: s[1], reverse=True)
        rank = [idx for idx, i in enumerate(board) if i[0] == k][0] + 1
        v = n // 10
        if rank % v == 0:
            g = grade[math.ceil(rank // v) - 1]
        else:
            g = grade[math.ceil(rank // v)]

        print(f'#{test_case} {g}')


if __name__ == '__main__':
    solve()
