'''
신문 헤드라인

input : 80byte 이하의 문자열 (input_string.)
output : 대문자로 변경된 문자열 (INPUT_STRING.)
'''

import sys

input = sys.stdin.readline

str_ = input()

print(str_.upper())