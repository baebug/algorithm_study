'''
[S/W 문제해결 기본] 1일차 - View
'''

def solve():
    for test_case in range(1, 11):
        s = 0
        n = int(input())
        arr = list(map(int, input().split()))
        for i in range(2, n-2):
            left = max(0, arr[i] - max(arr[i-1], arr[i-2]))
            right = max(0, arr[i] - max(arr[i+1], arr[i+2]))

            s += min(left, right)

        print(f'#{test_case} {s}')


if __name__ == '__main__':
    solve()
