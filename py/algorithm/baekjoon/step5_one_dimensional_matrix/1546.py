'''
1차원 배열 - 평균

세준이가 기말고사 점수를 조작한다.
모든 점수를 점수 / 본인최대점수 * 100 으로 고친 후 새로운 평균을 구하여라.

과목 N 주어지고 점수 주어짐.
'''
import sys

# def input():
#     return sys.stdin.readline()

n = int(sys.stdin.readline())
score = list(map(int, sys.stdin.readline().split()))
max_score = max(score)

for i in range(n):
    score[i] = score[i] / max_score * 100

print(sum(score) / n)