'''
문자열 - 알파벳 찾기

알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳에 대해서, 포함되어 있는 경우 위치(index)를, 아닌 경우 -1 을 출력해라.
'''
import sys

def input():
    return sys.stdin.readline().strip()

ans = []
_input = input()

for i in range(97, 123):
    if chr(i) in _input:
        ans.append(str(_input.index(chr(i))))
    else:
        ans.append("-1")

print(" ".join(ans))
