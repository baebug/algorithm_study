'''
파리 퇴치

이것도 잘 만들었음 ㅋㅋ
'''

def kill_count(arr, m, x, y):
    count = 0
    for i in range(x, x + m):
        for j in range(y, y + m):
            count += arr[i][j]

    return count


def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        n, m = map(int, input().split())
        arr = []
        ans = 0

        for _ in range(n):
            arr.append(list(map(int, input().split())))

        for i in range(n - m + 1):
            for j in range(n - m + 1):
                ans = max(ans, kill_count(arr, m, i, j))

        print(f'#{test_case} {ans}')


if __name__ == '__main__':
    solve()
