'''
평균값 구하기

# 소수점 제한 출력 https://jsikim1.tistory.com/226
'''


import sys

input = sys.stdin.readline

T = int(input())

for test_case in range(1, T + 1):
    inputArr = map(int, input().split())
    print(f'#{test_case} {round(sum(inputArr)/10)}')
