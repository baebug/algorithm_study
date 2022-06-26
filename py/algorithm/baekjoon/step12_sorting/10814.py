'''
정렬 - 나이순 정렬

온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하라.
'''
import sys

input = sys.stdin.readline

N = int(input())

li = [input() for _ in range(N)]
li.sort(key=lambda x: int(x.split()[0]))

print(''.join(li))