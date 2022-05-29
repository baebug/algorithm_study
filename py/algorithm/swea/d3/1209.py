'''
[S/W 문제해결 기본] 2일차 - Sum
'''

def rotate(arr):
    return [list(i) for i in zip(*arr[::-1])]


def sum_cross(arr):
    n = len(arr)
    s1 = s2 = 0
    for i in range(n):
        s1 += arr[i][i]
        s2 += arr[i][n-1-i]

    return max(s1, s2)


def sum_line(arr):
    r = 0
    for i in arr:
        tmp = sum(i)
        r = max(tmp, r)

    return r


def solve():
    t = 10

    for test_case in range(1, t + 1):
        n = int(input())
        arr = []
        ans = 0
        for i in range(100):
            tmp = list(map(int, input().split()))
            arr.append(tmp)

        ans = max(sum_cross(arr), sum_line(arr), sum_line(rotate(arr)))

        print(f'#{test_case} {ans}')


if __name__ == '__main__':
    solve()
