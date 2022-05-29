'''
[S/W 문제해결 기본] 3일차 - 회문2

break_point 를 활용한 n 중 for 문 탈출
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
        ans = 0

        for _ in range(100):
            tmp = list(input())
            arr.append(tmp)

        for r in arr:
            break_point = False
            for k in range(100, 0, -1):
                for i in range(101 - k):
                    if is_pal(r[i:i+k]):
                        ans = max(ans, k)
                        break_point = True
                        break
                if break_point:
                    break

        for r in rotate(arr):
            break_point = False
            for k in range(100, 0, -1):
                for i in range(101 - k):
                    if is_pal(r[i:i + k]):
                        ans = max(ans, k)
                        break_point = True
                        break
                if break_point:
                    break

        print(f'#{test_case} {ans}')


if __name__ == '__main__':
    solve()
