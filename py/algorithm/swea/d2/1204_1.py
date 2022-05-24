'''
최빈수 구하기

# sort with lambda https://h-sseung.tistory.com/55
# Counter https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=wideeyed&logNo=221540885097

라이브러리를 안 쓴다면 어떻게 풀 것인가?
dict 만들어서?
'''

import sys
from collections import Counter

input = sys.stdin.readline

t = int(input())

for test_case in range(1, t + 1):
    n = int(input())
    nums = map(int, input().split())
    m = sorted(Counter(nums).items(), key=lambda k:(k[1], k[0]), reverse=True)

    print(f'#{n} {m[0][0]}')