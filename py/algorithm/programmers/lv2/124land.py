def solution(n):
    answer = 0
    # 3진법으로 바꾼 뒤 3을 4로 바꾸면 끝인거같은데? (3진법 = 0, 1, 2 / 정답 = 1, 2, 4)
    # 3진법이라..
    digit = 1
    if n < 4:
        if n == 3: n = 4
        return str(n)
    
    while 1:
        if n >= 3:
            n, a = (n-1) // 3, (n-1) % 3
            if a == 0: a = 1
            elif a == 1: a = 2
            elif a == 2: a = 4
            answer += digit * a
            digit *= 10
        else:
            answer += digit * n
            return str(answer)