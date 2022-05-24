'''
간단한 소인수분해
'''

t = int(input())

for test_case in range(1, t + 1):
    n = int(input())
    a = b = c = d = e = 0
    while n != 1:
        if n % 2 == 0:
            n /= 2
            a += 1
        if n % 3 == 0:
            n /= 3
            b += 1
        if n % 5 == 0:
            n /= 5
            c += 1
        if n % 7 == 0:
            n /= 7
            d += 1
        if n % 11 == 0:
            n /= 11
            e += 1

    print(f'#{test_case} {a} {b} {c} {d} {e}')
