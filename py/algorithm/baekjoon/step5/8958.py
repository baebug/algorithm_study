'''
1차원 배열 - OX 퀴즈

점수 = 그 문제까지 연속된 O 의 개수
점수를 구하여라.
'''
import sys
from collections import deque

n = int(sys.stdin.readline())
ans = deque()

def ox_score(answer):
    for c in answer.strip():
        ans.append(c)
        
    score = 1
    total_score = 0

    while ans:
        c = ans.popleft()
        if c == "O":
            total_score += score
            score += 1
        else:
            score = 1

    print(total_score)
    
for _ in range(n):
    ox_score(sys.stdin.readline())

