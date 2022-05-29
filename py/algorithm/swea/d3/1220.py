'''
[S/W 문제해결 기본] 5일차 - Magnetic

ㅋㅋ else 하나 안써서 개고생함
find 는 string 에서만 사용 가능
'''

def find(string):
    idx = 0
    count = 0

    while 1:
        if string.find('2', idx) != -1:
            idx = string.find('2', idx) + 1
            if string.find('1', idx) != -1:
                count += 1
                idx = string.find('1', idx) + 1
            else:
                return count
        else:
            return count


def solve():
    t = 10

    for test_case in range(1, t+1):
        n = int(input())
        arr = []
        ans = 0

        arr = [list(input().split()) for _ in range(n)]
        board = [list(i) for i in zip(*arr[::-1])]

        for r in board:
            ans += find("".join(r))

        print(f'#{test_case} {ans}')


if __name__ == '__main__':
    solve()

