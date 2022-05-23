'''
간단한 N 의 약수

input : 정수 N (1 <= N <= 1,000)

output : 정수 N 의 약수를 오름차순으로 출력
'''

import sys

input = sys.stdin.readline

N = int(input())

arr = [1]
div = 2

while div <= N:
    if N % div == 0:
        arr.append(div)
    div += 1

print(*arr)