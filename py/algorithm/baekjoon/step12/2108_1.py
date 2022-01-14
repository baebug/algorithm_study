'''
정렬 - 통계학

N 은 홀수
1. 산술평균 : N 개의 수들의 합을 N 으로 나눈 값
2. 중앙값 : N 개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
3. 최빈값 : N 개의 수들 중 가장 많이 나타나는 값 (여러 개 있을 떄에는 최빈값 중 두 번째로 작은 값을 출력한다.)
4. 범위 : N 개의 수들 중 최댓값과 최솟값의 차이
'''
import sys

input = sys.stdin.readline

def 산술평균(arr):
    return round(sum(arr) / len(arr))

def 중앙값(arr):
    l = len(arr)//2
    if len(arr)&1:
        return sorted(arr)[l]
    else:
        return int(sum(sorted(arr)[l-1:l+1]) / 2) if (sum(sorted(arr)[l-1:l+1]) / 2) % 1 == 0 else sum(sorted(arr)[l-1:l+1]) / 2

def 최빈값(arr):
    tmp = [arr.count(i) for i in arr]
    rest_list = [arr[i] for i, e in enumerate(tmp) if e == max(tmp)]
    result = (sorted(set(rest_list)))
    if len(result) >= 2:
        return result[1]
    return result[0]

def 범위(arr):
    return max(arr) - min(arr)

N = int(input())
arr =[]

for _ in range(N):
    arr.append(int(input()))

print(산술평균(arr))
print(중앙값(arr))
print(최빈값(arr))
print(범위(arr))
