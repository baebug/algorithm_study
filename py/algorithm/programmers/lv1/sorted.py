def solution(strings, n):
    answer = sorted(strings, key=lambda x: (x[n], x)) # key 가 여러개면, 괄호로 감싸준다.
    
    return answer