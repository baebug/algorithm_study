'''
정렬 - 단어 정렬

알파벳 소문자로 이루어진 N 개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하라.
1. 길이가 짧은 것부터
2. 길이가 같으면 사전 순으로

같은 단어가 여러 번 입력된 경우 한 번씩만 출력한다.
'''
import sys

input = sys.stdin.readline

N = int(input())

words = [input() for _ in range(N)]
words = list(set(words))

words.sort(key=lambda x: x)
words.sort(key=lambda x: len(x))

print(''.join(words))