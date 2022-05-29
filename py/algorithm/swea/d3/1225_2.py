'''
[S/W 문제해결 기본] 7일차 - 암호생성기

함수를 만들게 되면 재귀를 찾게 되고, 필연적으로 복잡해진다.
최대한 반복문으로 해결할 방법을 생각해보자.
'''
from collections import deque


def solve():
    t = 10

    for test_case in range(1, t+1):
        n = int(input())
        arr = deque(map(int, input().split()))

        idx = 0
        count = 0

        while arr[idx] > 0:
            idx = count % 8
            dec = (count % 5) + 1

            arr[idx] -= dec
            count += 1

        arr[idx] = 0
        arr.rotate(-(idx+1))

        print(f'#{test_case}', *list(arr))


if __name__ == '__main__':
    solve()

