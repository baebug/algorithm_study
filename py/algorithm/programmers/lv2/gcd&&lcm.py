def getGCD(a, b):
    a, b = max(a, b), min(a, b)
    
    if a % b == 0:
        return b
    else:
        a, b = b, a % b
        return getGCD(a, b)
    
def getLCM(a, b):
    a, b = max(a, b), min(a, b)
    
    return a * b / getGCD(a, b)

def solution(arr):
    while len(arr) != 1:
        a = arr.pop()
        b = arr.pop()
        arr.append(getLCM(a, b))
        
    return arr[0]