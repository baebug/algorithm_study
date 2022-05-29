'''
아름이의 돌 던지기 (C++ 문제)
'''

from collections import Counter


def solve():
    t = int(input())

    for test_case in range(1, t+1):
        n = int(input())
        arr = map(int, input().split())
        abs_arr = list(map(abs, arr))
        a = sorted(Counter(abs_arr).items(), key=lambda k: k[0])[0]

        print(f'#{test_case} {a[0]} {a[1]}')


if __name__ == '__main__':
    solve()
