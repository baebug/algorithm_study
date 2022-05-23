'''
대각선 출력하기

output : #++++
output : +#+++
output : ++#++
output : +++#+
output : ++++#
'''

import sys

input = sys.stdin.readline

for i in range(5):
    print('+' * i + '#' + '+' * (4 - i))