def solution(begin, end):
    arr = [0] * (end + 1)
    for i in range(1, 10000001):
        mul = max(begin//i, 2)
        while i * mul <= end:
            arr[i * mul] = i
            mul += 1
    
    return arr[begin:end+1]