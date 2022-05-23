'''
1대1 가위바위보
가위 1, 바위 2, 보 3

input : a, b 

output : A 와 B 중 가위바위보의 승자를 출력
'''

import sys

input = sys.stdin.readline

a, b = map(int, input().split())
result = {a: 'A', b: 'B'}

if a + b != 4:
    print(result[max(a, b)])
else:
    print(result[min(a, b)])

