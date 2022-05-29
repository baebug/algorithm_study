'''
[S/W 문제해결 기본] 3일차 - 회문1
'''

def is_pal(arr):
    n = len(arr)

    for i in range(n//2):   # 0 1
        if arr[i] != arr[n-i-1]:
            return False
    return True


def rotate(arr):
    return [list(i) for i in zip(*arr[::-1])]


def solve():
    t = 10

    for test_case in range(1, t+1):
        n = int(input())
        arr = []
        count = 0

        for _ in range(8):
            tmp = list(input())
            arr.append(tmp)

        for r in arr:
            for i in range(9-n):
                if is_pal(r[i:i+n]):
                    count += 1

        for r in rotate(arr):
            for i in range(9-n):
                if is_pal(r[i:i+n]):
                    count += 1

        print(f'#{test_case} {count}')


if __name__ == '__main__':
    solve()
