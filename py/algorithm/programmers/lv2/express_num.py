def solution(n):
    answer = 0
    # 연속한 자연수들로 표현
    # n, n+1, ..., n+(i-1)
    if n == 1: return 1

    # i 개의 연속된 자연수의 합으로 표현이 가능한가?
    for i in range(1, n):
        m = sum(range(i))   # 0 부터 i-1 까지의 합
        
        if m >= n:          # m == n 을 허용할 경우, 15의 경우 자연수 6개의 합으로 표현이 가능하는 뜻이 됨.
            break
        elif (n - m) % i == 0:
            answer += 1
        
    return answer