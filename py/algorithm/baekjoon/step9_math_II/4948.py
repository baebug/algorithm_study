'''
기본 수학 2 - 베르트랑 공준

임의의 자연수 n에 대하여, n 보다 크고 2n 보다 작거나 같은 소수는 적어도 하나 존재한다.
자연수 n 이 주어졌을 때, n 보다 크고 2n 보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하라.

input:
    A (최대 123,456)
    B
    ...
    0 (end)
'''
import sys

def input():
    return sys.stdin.readline().strip()

eratos = [False, False] + [True for _ in range(246911)]

for i in range(2, int(246912 ** 0.5) + 1):
    if eratos[i]:
        for j in range(i*2, 246913, i):
            eratos[j] = False

while 1:
    num = int(input())
    if num == 0: break
    cnt = 0
    for i in range(num + 1, num*2 + 1):
        if eratos[i]: cnt += 1
    print(cnt)

    
