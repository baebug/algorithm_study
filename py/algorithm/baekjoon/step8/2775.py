'''
기본 수학 1 - 부녀회장이 될테야

a 층의 b 호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람 수의 합만큼 사람들을 데려와 살아야 하는 아파트.

k층의 n호에는 몇 명이 사는가?
단, 아파트는 0층부터이며, 0층의 i 호에는 i 명이 산다.

input:
    T (테케 수)
    k
    n
'''
import sys

def input():
    return sys.stdin.readline().strip()

def cal_people(floor, column):
    sum = 0
    if floor == 0: return column

    if apt[column - 1][floor - 1] == -1:
        for i in range(1, column + 1):
            sum += cal_people(floor - 1, i)
        apt[column - 1][floor - 1] = sum
    
    return apt[column - 1][floor - 1]

t = int(input())

for _ in range(t):
    k = int(input())
    n = int(input())
    apt = [[-1 for _ in range(k)] for _ in range(n)]
    print(cal_people(k, n))



#   2층     1,          1+1+2,      1+1+2+1+2+3,
#   1층     1,            1+2,            1+2+3,          1+2+3+4,  
#   0층     1,              2,                3,                4,          5,          6,          7,          8,          9,          ...