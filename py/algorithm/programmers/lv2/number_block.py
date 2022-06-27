def isPrime(n):
    tmp = n ** .5
    for i in range(2, int(tmp)+1):
        if n % i == 0:
            return False
    return True
      
def solution(begin, end):
    ans = [1] * (end - begin + 1)
    if begin == 1: ans[0] = 0
    
    for i in range(begin, end+1):
        div = 2
        while div ** 2 <= i:
            if i % div == 0 and i / div <= 10000000:
                ans[i - begin] = i / div
                break
            div += 1
            
    return ans