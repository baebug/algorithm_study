'''
정렬 - 수 정렬하기 3

카운팅 정렬 (수의 범위가 작을 때 효과적이다.)
'''
import sys

def input():
    return sys.stdin.readline().strip()

def counting_sort(arr, max):
    
    counting_arr = [0] * (max + 1)

    for i in arr:
        counting_arr[i] += 1
    
    for i in range(max):
        counting_arr[i+1] += counting_arr[i]
    
    output_arr = [-1] * len(arr)

    for i in arr:
        output_arr[counting_arr[i] - 1] = i
        counting_arr[i] -= 1
    
    return output_arr
    
N = int(input())
arr = []
for _ in range(N):
    arr.append(int(input()))

max_arr = max(arr)

for i in counting_sort(arr, max_arr):
    print(i)