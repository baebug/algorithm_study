'''
문자열 - 단어의 개수

영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 몇 개의 단어가 있을까?
너무 쉬운데?
'''
import sys

def input():
    return sys.stdin.readline().strip()

ans = input().split()
print(len(ans))