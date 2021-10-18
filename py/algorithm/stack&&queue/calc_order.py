# (()(()())) 이런 식으로 괄호가 주어질 때,
# 5114223345 이렇게 계산 순서가 출력되게 만들어라.
# 짝지어지는 괄호의 index를 기억한다.
import sys

bracket = sys.stdin.readline().strip()

result = [None] * len(bracket)
temp = []
count = 1

for i in range(len(bracket)):
    if bracket[i] == "(":
        temp.append(i)
    else:
        result[temp.pop()] = count
        result[i] = count
        count += 1

print(result)