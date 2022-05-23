'''
중간값 찾기

input1 : 홀수 N (N은 9이상 199 이하의 정수이다. (9 ≤ N ≤ 199))
input2 : N 개의 점수
'''

import sys

input = sys.stdin.readline

N = int(input())
scoreArr = sorted(list(map(int, input().split())))

print(scoreArr[N//2])