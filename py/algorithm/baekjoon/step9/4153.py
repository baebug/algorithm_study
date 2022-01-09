'''
기본 수학 2 - 직각삼각형

주어진 세 변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
마지막 줄에는 0 0 0 이 입력된다. 맞으면 "right" 아니면 "wrong" 출력
'''
import sys

def input():
    return sys.stdin.readline().strip()

while 1:
    arr = list(map(int, input().split()))
    l = max(arr)
    if l == 0: break
    arr.remove(l)

    if arr[0] ** 2 + arr[1] ** 2 == l ** 2:
        print("right")
    else:
        print("wrong")