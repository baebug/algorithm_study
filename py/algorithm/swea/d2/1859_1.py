'''
백만 장자 프로젝트

너무 무식함 (역산을 생각해보자)
'''
from collections import deque


def calc(arr):
    if not arr:
        return 0

    if max(arr) == arr[0]:
        arr.popleft()
        return calc(arr)

    idx = arr.index(max(arr))

    m = 0
    for i in range(idx):
        m += arr.popleft()

    return idx * arr.popleft() - m


def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        n = int(input())
        arr = deque(list(map(int, input().split())))
        profit = 0

        while arr:
            profit += calc(arr)

        print(f'#{test_case} {profit}')


if __name__ == '__main__':
    solve()
