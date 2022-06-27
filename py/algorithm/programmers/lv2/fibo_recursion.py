# 재귀 호출 깊이 제한을 풀어줘야 하기 때문에 좋은 방법이 아님
import sys
sys.setrecursionlimit(10**7)

dict_ = {0: 0, 1: 1, 2: 1}

def fibo(n):
    if n in dict_.keys():
        pass
    else:
        tmp = fibo(n-1) + fibo(n-2)
        dict_[n] = tmp % 1234567
    
    return dict_[n]

def solution(n):
    return fibo(n)