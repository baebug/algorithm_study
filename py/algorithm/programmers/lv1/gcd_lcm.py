def solution(n, m):
    a = max(n, m)
    b = min(n, m)
    
    # 유클리드 호제법
    while a % b != 0:
        a, b = b, a % b
    
    gcd = b
    lcm = n * m / b
    
    return [gcd, lcm]
    