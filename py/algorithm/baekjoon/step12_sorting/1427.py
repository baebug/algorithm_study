'''
정렬 - 소트인사이드

정렬하려고 하는 수 N 이 주어지면 각 자리수를 내림차순으로 정렬하여 출력하라.
'''
import sys

input = sys.stdin.readline

li = list(input().strip())

li.sort(reverse=True)

print("".join(li))