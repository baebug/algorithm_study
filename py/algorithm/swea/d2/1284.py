'''
새로운 불면증 치료법
'''

import sys

input = sys.stdin.readline

t = int(input())

for test_case in range(1, t + 1):
    arr = [i for i in range(10)]
    n = int(input())
    count = 0

    while arr:
        count += 1
        n_ = n * count
        str_n = str(n_)
        for c in str_n:
            if int(c) in arr:
                arr.remove(int(c))

    print(f'#{test_case} {n * count}')