'''
재귀 - 별 찍기 - 10

구글 검색함
'''
import sys

def input():
    return sys.stdin.readline().strip()

def star(n, arr):
    matrix = []

    if n == 1:
        return arr
    else:
        for i in arr:
            matrix.append(i * 3)
        for i in arr:
            matrix.append(i + " " * len(arr) + i)
        for i in arr:
            matrix.append(i * 3)
        return star(n//3, matrix)

first = ["*"]
n = int(input())        

ans = star(n, first)

for i in ans:
    print(i)