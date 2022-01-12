'''
브루트 포스 - 블랙잭

N 장의 카드를 모두 숫자가 보이도록 바닥에 놓는다.
N 장의 카드 중에서 3장의 카드를 고르는 데, M 을 넘지 않으면서 M 과 최대한 가깝게 반들어야 한다.
N 장의 카드에 써져 있는 숫자가 주어졌을 때, 가장 가까운 카드 3장의 합을 출력하라.

input:
    N(3 ~ 100)  M(10 ~ 300,000)
    a b c .. n (N 개)
'''
import sys

def input():
    return sys.stdin.readline().strip()

N, M = map(int, input().split())
nums = list(map(int, input().split()))
ans = -1

for i in range(N - 2):
    for j in range(i + 1, N - 1):
        for k in range(j + 1, N):
            result = nums[i] + nums[j] + nums[k]
            if result <= M:
                ans = max(ans, result)

print(ans)



