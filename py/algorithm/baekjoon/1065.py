'''
함수 - 한수

양의 정수 X 의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
N이 주어졌을 때, 1과 N 사이의 한수의 개수를 출력하는 프로그램을 작성해라.
'''
import sys

def input():
    return sys.stdin.readline()

def isHan(n):
    tmp = list(map(int, str(n)))    # 123 -> [1, 2, 3]
    l = len(tmp)
    if l <= 2:
        return True
    else:
        cv = tmp[0] - tmp[1]
        i = 1
        while i != l - 1:
            if tmp[i] - tmp[i + 1] == cv:
                pass
            else:
                return False
            i += 1
        return True

def printHan(n):
    ans = []
    for i in range(1, n + 1):
        if isHan(i):
            ans.append(i)

    print(len(ans))

printHan(int(input()))