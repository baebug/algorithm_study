'''
브루트 포스 - 영화감독 숌

종말의 숫자란 어떤 수에서 6이 적어도 3개이상 연속으로 들어가는 수를 말한다.
숌이 만든 N번째 영화의 제목에 들어간 숫자를 출력하는 프로그램을 작성하시오.

input:
    N
'''
import sys

def input():
    return sys.stdin.readline().strip()

N = int(input())

li = []
num = 1

while len(li) < N:
    if "666" in str(num):
        li.append(num)
        num += 1
    else:
        num += 1

print(li[-1])