'''
1차원 배열 - 나머지

수 10개를 입력받은 뒤 이를 42로 나눈 나머지를 구한다.
그 다음 서로 다른 값이 몇 개 있는지 출력한다.
'''
import sys

arr = set()
for _ in range(10):
    arr.add(int(sys.stdin.readline()) % 42)

print(len(arr))
