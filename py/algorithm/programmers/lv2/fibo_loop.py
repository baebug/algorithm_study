def solution(n):
    arr = [0, 1] + [0 for i in range(n+1)]
    
    # if n == 0: return 0
    # if n == 1: return 1

    for i in range(2, n+1):
        arr[i] = (arr[i-1] + arr[i-2]) % 1234567
    
    return arr[n]