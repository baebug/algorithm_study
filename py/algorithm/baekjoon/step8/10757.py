'''
기본 수학 1 - 큰 수 A + B

파이썬 같은 언어는 10,000자리 정도의 자연수도 자유롭게 다룰 수 있습니다.
하지만 C/C++이라면 이 문제를 어떻게 풀까요? C/C++ 사용자가 아니더라도 고민해 보면 좋을 것입니다.

입력값이 최대 10^10000 이므로 10001자리의 수가 들어간다.
그 이상의 Capacity를 가진 배열 arr_a, arr_b 를 할당하고
문자열로 입력받은 A 와 B 를 배열 안에 넣는다.   (chr[10002] arr_a 이런 식으로?)

대신 다른 자릿수의 수가 들어올 수 있기 때문에 끝을 맞춰야하는데, 뒤집어서 넣는게 더 편할듯

즉, 입력받은 엄청 큰 수를 뒤집어서 배열에 넣는다.

그 다음 idx = 0 부터 끝까지 덧셈을 진행하는데 변수 tmp 에 오버되는 수를 가져가서 더해준다.

for (int i = 0; i = 10005; i++) {
    tmp = int(arr_a[i]) + int(arr_b[i])
    if (tmp >= 10) {
        result[i+1] += tmp[1]
    }
    result[i] += tmp[0]
}

이런 식으로 더해주고 나중에 result 를 다시 뒤집어서 출력하면 안되겠나?
'''
import sys

def input():
    return sys.stdin.readline().strip()

A, B = list(map(int, input().split()))

print(A + B)