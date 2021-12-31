'''
문자열 - 상수

정상근 동생 정상수는 수학을 정말 못한다. 상수는 수를 반대로 읽는다.
두 수를 비교할 때 상수의 대답을 출력하여라. [::-1]
'''
import sys

def input():
    return sys.stdin.readline().strip()

a, b = input().split()
r_a = int(a[::-1])
r_b = int(b[::-1])

print(max(r_a, r_b))