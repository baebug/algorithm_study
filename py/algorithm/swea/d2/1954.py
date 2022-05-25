'''
달팽이 숫자

좀 더 쉽게 할 수 있는가?
이차원배열의 x, y 을 너무 오랜만에 써봐서 조금 헤맨거지, 다시 풀면 괜찮을듯? 푸는 방법 자체는 준수했다고 생각함.
물론 더 나은 방법 or 다른 방식의 해석도 존재할테니 아라보자.
'''

def snail(arr, pos_x, pos_y, n, m):    # arr, (1, 1), 3, 16
    if n == 1:
        arr[pos_x][pos_y] = m + 1
        return arr
    elif n == 0:
        return arr

    for i in range(n):          # 0, 1
        arr[pos_x][pos_y + i] = i + 1 + m
        arr[pos_x + n - 1][pos_y + i] = 3 * n - 2 - i + m

    for j in range(1, n-1):     # 1
        arr[pos_y + j][pos_x] = 4 * n - 3 - j + m
        arr[pos_y + j][pos_x + n - 1] = n + j + m

    return snail(arr, pos_x + 1, pos_y + 1, n - 2, m + 4*(n-1))


def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        n = int(input())
        arr = [[0 for _ in range(n)] for _ in range(n)]

        snail(arr, 0, 0, n, 0)

        print(f'#{test_case}')
        for i in range(len(arr)):
            print(*arr[i])


if __name__ == '__main__':
    solve()
