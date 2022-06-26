'''
정렬 - 좌표 압축

수직선 위에 N 개의 좌표 X1, X2, ..., Xn 이 있다.
Xi 를 좌표 압축한 결과 X'i 의 값은 Xi > Xj 를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
(n 개의 좌표중 자기 보다 작은 좌표의 수)
'''
import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
s_arr = sorted(list(set(arr)))

for i in arr:
    print(s_arr.index(i), end=" ")
