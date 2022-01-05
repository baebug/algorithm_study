'''
기본 수학 1 - 분수찾기

지그재그 분수 1 - 2 - 3 - 4 - 5 - 6
짝수는 정순, 홀수는 역순
X가 주어졌을 때, X 번 째 분수를 구하는 프로그램을 작성.
'''
import sys

def input():
    return sys.stdin.readline().strip()

X = int(input())    # 몇번째 대각인지 찾아야 함.
i = 0

while X > 0:    # i 번 대각
    i += 1
    X -= i

cnt = X + i

if i & 1:   # i 가 홀수면
    print(str(i - cnt + 1) + "/" + str(cnt))
else:
    print(str(cnt) + "/" + str(i - cnt + 1))