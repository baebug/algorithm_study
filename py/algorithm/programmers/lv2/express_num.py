'''
다른 사람의 풀이에 뭔가 수학적인 이슈가 있는데...
일단 pass
'''

def solution(n):
    answer = 0
    # 1 ~ k 의 합 --> (k + 1) * k / 2 를 빼면 0 또는 k 로 나누어 떨어지는 수 이다.
    for i in range(1, n + 1):
        div = (i + 1) * i // 2
        if n >= div:
            if n - div == 0 or (n - div) % i == 0:
                answer += 1
            
    return answer

print(solution(24))
