'''
문자열 - 문자열 반복

문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하라.

N(테케 수)
R S 가 공백으로 구분되어 주어진다.
'''
import sys

def input():
    return sys.stdin.readline().strip()

n = int(input())

for _ in range(n):
    R, S = input().split()
    R = int(R)
    ans = ""
    for c in S:
        ans += c * R
    print(ans)