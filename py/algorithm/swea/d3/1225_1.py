'''
[S/W 문제해결 기본] 7일차 - 암호생성기

당 떨어져서 머리가 너무 안돌아감 ㅡ.ㅡ
boolean 으로 while/for 문 탈출하기

객체 지향의 함정에 빠진듯? 좀 더 간단하게 생각하자
'''

from collections import deque


def cycle(arr):
    for i in range(5):
        arr[i] -= i + 1
    arr.rotate(-5)


def cycle_fin(arr, i):
    if arr[0] > i:
        arr[0] -= i
        arr.rotate(-1)
        return cycle_fin(arr, i+1)
    else:
        arr[0] = 0
        arr.rotate(-1)
        return arr


def solve():
    t = 10

    for test_case in range(1, t+1):
        n = int(input())
        arr = deque(map(int, input().split()))

        break_point = True
        for i in range(5):
            if arr[i] < i + 2:
                break_point = False

        while break_point:
            cycle(arr)
            for i in range(5):
                if arr[i] < i + 2:
                    break_point = False

        cycle_fin(arr, 1)

        print(f'#{test_case}', *list(arr))


if __name__ == '__main__':
    solve()

