'''
1차원 배열 - 평균은 넘겠지

첫째 줄: 테케 수 
둘째 줄 ~: 학생수, 각 점수
각 케이스마다 한 줄씩 평균 넘는 학생들의 비율 출력 (반올림하여 소수 셋째 자리까지)
'''
import sys

def input():
    return sys.stdin.readline()

c = int(input())

for _ in range(c):
    _input = list(map(int, input().split()))
    n = _input[0]
    score = _input[1:]
    avg_score = sum(score) / n
    over_avg = sum([1 for s in score if s > avg_score])
    print('%.3f' % round(over_avg / n * 100, 3) + "%")
    