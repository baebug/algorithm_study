'''
기본 수학 1 - ACM 호텔

호텔 매니저 지우는 손님이 도착하는 대로 빈 방을 배정한다. (호텔 정문으로부터 걷는 거리가 가장 짧도록 방을 배정함)
H x W 형태의 호텔에서 모든 방이 비어있을 때, N번 째로 도착한 손님에게 배정될 방 번호를 계산하여라.

방이 전부 비어있으면 엄청 쉬운 것 같은데?

input:
    T(테케 수)
    H(층 수) W(각 층의 방 수) N(손님 순서)
'''
import sys

def input():
    return sys.stdin.readline().strip()

t = int(input())

for _ in range(t):
    H, W, N = list(map(int, input().split()))
    if N % H == 0:
        h = H
        w = N // H
    else:
        h = N % H
        w = N // H + 1
    w2 = '{0:02d}'.format(w)
    print(str(h) + w2)


# 몫과 나머지를 사용할때는 항상 나누어 떨어지는 경우를 신경써야한다!!