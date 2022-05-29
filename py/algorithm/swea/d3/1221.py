'''
[S/W 문제해결 기본] 5일차 - GNS
'''

def solve():
    dict_ = {"ZRO": 0, "ONE": 1, "TWO": 2, "THR": 3, "FOR": 4, "FIV": 5, "SIX": 6, "SVN": 7, "EGT": 8, "NIN": 9}
    t = int(input())

    for test_case in range(1, t+1):
        a, n = input().split()

        arr = input().split()
        ans = sorted(arr, key=lambda k: dict_[k])

        print(f'#{test_case}')
        print(" ".join(ans))


if __name__ == '__main__':
    solve()

