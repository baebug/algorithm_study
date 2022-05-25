'''
중간 평균값 구하기
'''

from collections import deque


def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        arr = deque(sorted(map(int, input().split())))
        arr.pop()
        arr.popleft()

        ans = round(sum(arr) / len(arr))

        print(f'#{test_case} {ans}')


if __name__ == '__main__':
    solve()
