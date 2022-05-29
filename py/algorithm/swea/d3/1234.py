'''
[S/W 문제해결 기본] 10일차 - 비밀번호
'''

def solve():
    t = 10

    for test_case in range(1, t+1):
        a, arr = input().split()
        arr = list(arr)
        idx = 0
        n = -1

        while idx < len(arr):
            if n != arr[idx]:
                n = arr[idx]
            else:
                arr.pop(idx)
                arr.pop(idx - 1)
                idx = -1
                n = -1
            idx += 1

        print(f'#{test_case}', "".join(arr))


if __name__ == '__main__':
    solve()

