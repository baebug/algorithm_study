def isPrime(n):
    tmp = int(n ** .5)
    
    for i in range(2, tmp + 1):
        if n % i == 0:
            return False
    
    return True

def solution(n):
    ans = [i for i in range(2, n+1) if isPrime(i)]
    
    return len(ans)