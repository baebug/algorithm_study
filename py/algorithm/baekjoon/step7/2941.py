'''
문자열 - 크로아티아 알파벳

replace 메서드는 변경한 문자열 값을 리턴해주므로 다시 초기화해주는 작업이 필요하다. sort, sorted 에 비슷한 상황이 있었던 것 같다.
'''
import sys

def input():
    return sys.stdin.readline().strip()

cr = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

def solve(string):
    for c in cr:
        while c in string:
            string = string.replace(c, "a")
    return len(string)

print(solve(input()))
