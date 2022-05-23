'''
알파벳을 숫자로 변환

input : 알파벳 대문자로 이루어진 문자열

# python List 요소 한번에 출력하기 https://yeomss.tistory.com/160
# join(split 반대) https://devpouch.tistory.com/77
'''

import sys

input = sys.stdin.readline

str_ = list(input().strip())
result = []

for c in str_:
    result.append(ord(c)-64)

print(*result)