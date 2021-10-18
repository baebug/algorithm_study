# 스택으로 수열 만들기
# [3 1 4 2] 이런 식으로 입력 되면 Yes, No 로 대답한다.

# 입력은 1 부터 시작해서 총 수열의 길이만큼 stack에 입력된다.
# stack 의 top 이 찾는 수와 같으면 pop() 한다. -> 이때 뽑고나서 또 필요한 수인 경우를 고려해서 while문으로 작성한다.
# 모든 입력이 끝났는데 stack 이 비어있지 않다면 No, 비어있다면 Yes 이다.

import sys

_input = list(map(int, sys.stdin.readline().strip().split()))
print(_input)
_stack = []
result = []
index = 0

for i in range(len(_input)):
    _stack.append(i + 1)

    while 1:
        if _stack:
            if _stack[len(_stack) - 1] == _input[index]:
                result.append(_stack.pop())
                index += 1
            else:
                break
        else:
            break

if _stack:
    print("No")
else:
    print("Yes")