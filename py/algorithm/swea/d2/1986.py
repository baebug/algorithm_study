'''
지그재그 숫자
'''

def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        n = int(input())
        ans = 0

        for i in range(1, n+1):
            if i & 1:
                ans += i
            else:
                ans -= i

        print(f'#{test_case} {ans}')


if __name__ == '__main__':
    solve()
