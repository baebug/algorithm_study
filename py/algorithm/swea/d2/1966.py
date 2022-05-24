'''
숫자를 정렬하자
'''

def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        n = int(input())
        arr = map(int, input().split())
        print(f'#{test_case}', *sorted(arr))


if __name__ == '__main__':
    solve()
