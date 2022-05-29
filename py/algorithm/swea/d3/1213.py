'''
[S/W 문제해결 기본] 3일차 - String
'''

def solve():
    t = 10

    for test_case in range(1, t + 1):
        n = int(input())
        f_ = input()
        str_ = input()
        idx = 0
        count = 0

        while 1:    # len(f_) + idx < len(str_)
            if str_.find(f_, idx) != -1:
                idx = str_.find(f_, idx) + len(f_)
                count += 1
            else:
                break

        print(f'#{test_case} {count}')


if __name__ == '__main__':
    solve()
