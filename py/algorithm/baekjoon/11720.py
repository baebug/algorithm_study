'''
문자열 - 숫자의 합

N 개의 숫자가 공백없이 주어진다. 이 수들의 합을 구하여라.
첫째 줄에 숫자의 개수 N이 주어진다.
둘째 줄에 숫자 N개가 공백없이 주어진다.
'''
import sys

def input():
    return sys.stdin.readline()

n = int(input())
nums = list(map(int, input().strip()))

print(sum(nums))