'''
날짜 계산기
'''
cal = {1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31}
t = int(input())

for test_case in range(1, t + 1):
    m1, d1, m2, d2 = map(int, input().split())
    date = 0

    if m1 != m2:
        for i in range(m1, m2):
            date += cal[i]

    date += d2 - d1 + 1

    print(f'#{test_case} {date}')