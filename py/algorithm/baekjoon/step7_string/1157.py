'''
문자열 - 단어 공부

알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하라.
가장 많이 사용된 알파벳을 대문자로 출력 (여러개면 ? 출력)
'''
# 65 - 90 : A - Z

import sys

def input():
    return sys.stdin.readline().strip()

word = input().upper()
arr = []

for i in range(65, 91):
    arr.append(word.count(chr(i)))

if arr.count(max(arr)) >= 2:
    print("?")
else:
    print(chr(65 + arr.index(max(arr))))
