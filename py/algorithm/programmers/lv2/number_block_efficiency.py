def isPrime(n):
    tmp = n ** .5
    for i in range(2, int(tmp)+1):
        if n % i == 0:
            return False
    return True
      
def solution(begin, end):
    ans = []
    for i in range(begin, end + 1):
        if i == 1:
            ans.append(0)
        elif isPrime(i):
            ans.append(1)
        else:
            div = 2
            while 1:
                if i  % div == 0:
                    d = i // div
                    if i % d == 0:
                        ans.append(d)
                        break
                div += 1
            
    return ans