def hanoi(n, st, ed):
    tmp = []

    if n == 1:
        tmp.append([st, ed])
        return tmp
    
    # 변수 이름 remainder 는 너무 긴데..
    a = 6 - st - ed
    
    tmp += hanoi(n-1, st, a)
    tmp.append([st, ed])
    tmp += hanoi(n-1, a, ed)
    
    return tmp

def solution(n):
    # 재귀
    return hanoi(n, 1, 3)