'''
문자열 - 다이얼

단어가 주어지면 다이얼을 걸기 위해 필요한 최소 시간을 출력한다.
하드코딩 하기 싫은데..
'''
import sys

def input():
    return sys.stdin.readline().strip()

def toNum(char):
    if char in ["A", "B", "C"]:
        return 3
    elif char in ["D", "E", "F"]:
        return 4
    elif char in ["G", "H", "I"]:
        return 5
    elif char in ["J", "K", "L"]:
        return 6
    elif char in ["M", "N", "O"]:
        return 7
    elif char in ["P", "Q", "R", "S"]:
        return 8
    elif char in ["T", "U", "V"]:
        return 9
    elif char in ["W", "X", "Y", "Z"]:
        return 10
    else:
        return 0

def solve(string):
    sum = 0
    for c in string:
        sum += toNum(c)
    return sum

print(solve(input()))