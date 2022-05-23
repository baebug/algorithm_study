'''
연월일 달력

input1 : 테케 수 T
input2 : 8자리의 숫자

output : 날짜가 유효한 경우 YYYY/MM/DD, 그 외 -1
'''

import sys

input = sys.stdin.readline

T = int(input())

def isDate(month, date):
    if month == 0 or date == 0:
        return False
    if month > 13 or date > 31:
        return False
    if month == 2 and date > 29:
        return False
    if month in (4, 6, 9, 11) and date > 30:
        return False

    return True

for test_case in range(1, T + 1):
    num = input() # 8자리의 숫자가 입력됨 [0] ~ [7]
    year = int(num[:4])
    month = int(num[4:6])
    date = int(num[6:])

    if isDate(month, date):
        print(f'#{test_case} {year:04d}/{month:02d}/{date:02d}')
    else:
        print(f'#{test_case} -1')

