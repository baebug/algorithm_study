'''
기본 수학 2 - 소수

M 과 N 이 주어질 때 M 이상, N 이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾아라.
input:
    M
    N
'''
import sys

def input():
    return sys.stdin.readline().strip()

eratos = [False, False] + [True for _ in range(9999)]

for i in range(2, 101):
    if eratos[i]:
        for j in range(i * 2, 10001, i):
            eratos[j] = False

M = int(input())
N = int(input())

sum_nums = 0
min_num = 10001

for i in range(M, N + 1):
    if eratos[i]:
        sum_nums += i
        min_num = min(min_num, i)

if sum_nums != 0:
    print(sum_nums)
    print(min_num)
else:
    print(-1)





