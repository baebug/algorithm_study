'''
[S/W 문제해결 기본] 4일차 - 거듭 제곱

재귀를 사용하라. (문제 조건임)
'''

def mul(a, b):
    if b == 1:
        return a

    return a * mul(a, b-1)


def solve():
    t = 10

    for test_case in range(1, t+1):
        input()
        n, m = map(int, input().split())

        print(f'#{test_case} {mul(n, m)}')


if __name__ == '__main__':
    solve()
