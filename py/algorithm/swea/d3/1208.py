'''
[S/W 문제해결 기본] 1일차 - Flatten
'''

def flatten(arr):
    max_i = arr.index(max(arr))
    min_i = arr.index(min(arr))

    arr[max_i] -= 1
    arr[min_i] += 1


def solve():
    for test_case in range(1, 11):
        n = int(input())
        arr = list(map(int, input().split()))
        for i in range(n):
            flatten(arr)

        print(f'#{test_case} {max(arr) - min(arr)}')


if __name__ == '__main__':
    solve()
