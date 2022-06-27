# 피보나치랑 똑같음
def solution(n):
    arr = [1, 1, 2] + [0 for i in range(n)]

    for i in range(3, n + 1):
        arr[i] = (arr[i-2] + arr[i-1]) % 1234567
    
    return arr[n]