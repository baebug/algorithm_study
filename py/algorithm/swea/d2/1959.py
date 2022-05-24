'''
두 개의 숫자열
'''

def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        n, m = map(int, input().split())        # 두 배열의 길이  : 5 3
        a = list(map(int, input().split()))     # 배열 a 의 원소
        b = list(map(int, input().split()))     # 배열 b 의 원소
        ans = 0

        if n == m:
            for i in range(n):
                ans += a[i] * b[i]

        if len(a) == max(m, n):     # a 가 더 길 때
            for i in range(len(a) - len(b) + 1):    # i = 0, 1, 2
                tmp = 0
                for j in range(len(b)):
                    tmp += a[i + j] * b[j]
                if tmp > ans:
                    ans = tmp
        else:
            for i in range(len(b) - len(a) + 1):
                tmp = 0
                for j in range(len(a)):
                    tmp += a[j] * b[i + j]
                if tmp > ans:
                    ans = tmp

        print(f'#{test_case} {ans}')


if __name__ == '__main__':
    solve()
