def factorial(n):
    sum_ = n
    for i in range(1, n):
        sum_ *= i
    
    return sum_

def solution(n, k):
    ans = []
    arr = list(range(1, n+1))
    # n = 4 일 때, 1234 1243 1324 1342 1423 1432 ... 이렇게
    tmp = k - 1
    cnt = 1
    
    while tmp != 0:
        a = tmp // factorial(n - cnt)
        tmp %= factorial(n - cnt)
        
        ans.append(arr.pop(a))
        
        if tmp == factorial(n - cnt) - 1:
            arr.sort(reverse=True)
            break
        
        cnt += 1
        
    return ans + arr
        
