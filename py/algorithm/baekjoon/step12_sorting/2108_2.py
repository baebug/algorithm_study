'''
정렬 - 통계학

N 은 홀수
1. 산술평균 : N 개의 수들의 합을 N 으로 나눈 값
2. 중앙값 : N 개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
3. 최빈값 : N 개의 수들 중 가장 많이 나타나는 값 (여러 개 있을 떄에는 최빈값 중 두 번째로 작은 값을 출력한다.)
4. 범위 : N 개의 수들 중 최댓값과 최솟값의 차이
'''
import sys
from collections import Counter

input = sys.stdin.readline

def 산술평균(arr):
    return round(sum(arr) / len(arr))

def 중앙값(arr):
    l = len(arr)//2
    return arr[l]

def 최빈값(arr):
    cnt = Counter(arr)
    mode = cnt.most_common()
    if len(mode) > 1:
        if mode[0][1] == mode[1][1]:
            return mode[1][0]
    return mode[0][0]

def 범위(arr):
    return max(arr) - min(arr)

N = int(input())
arr =[]

for _ in range(N):
    arr.append(int(input()))

arr.sort()

print(산술평균(arr))
print(중앙값(arr))
print(최빈값(arr))
print(범위(arr))