'''
[S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
'''

def solve():
    t = int(input())
    dict_ = {'0001101': 0, '0011001': 1, '0010011': 2, '0111101': 3, '0100011': 4, '0110001': 5,
             '0101111': 6, '0111011': 7, '0110111': 8, '0001011': 9}

    for test_case in range(1, t+1):
        n, m = map(int, input().split())
        code = [input() for _ in range(n)]

        idx = 0
        row = ''

        for r in code:
            if '1' in r:
                idx = r.rindex('1')
                row = r[idx-55:idx+1]
                break

        pw = ''

        for i in range(8):
            pw += str(dict_[row[7*i:7*(i+1)]])

        result = 0

        for i in range(len(pw)):
            if i & 1:
                result += int(pw[i])
            else:
                result += 3 * int(pw[i])

        ans = 0

        if result % 10 == 0:
            for c in pw:
                ans += int(c)

        print(f'#{test_case} {ans}')


if __name__ == '__main__':
    solve()

