'''
어디에 단어가 들어갈 수 있을까
'''

def rotate(arr):
    return [list(i) for i in zip(*arr[::-1])]


def check(arr, n, k):
    count = 0
    for r in arr:
        i = 0
        while i <= n - k:
            if r[i:i+k+2] == [0] + [1] * k + [0]:
                count += 1
            i += 1
    return count


def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        n, k = map(int, input().split())
        board = [[0] * (n+2)]
        for i in range(n):
            board.append([0] + list(map(int, input().split())) + [0])
        board.append([0] * (n+2))

        print(f'#{test_case}', check(board, n, k) + check(rotate(board), n, k))


if __name__ == '__main__':
    solve()
