# 메모장 만들기
# P a : 커서 왼쪽에 'a' 입력
# L : 커서를 왼쪽으로 한 칸 이동
# R : 커서를 오른쪽으로 한 칸 이동
# D : 커서 왼쪽의 글자를 1개 지움

# s, commands 가 입력되었다고 가정,

left = list(s)
right = []

for c in commands:
    if c.split()[0] == "P":
        left.append(c.split()[1])
    elif c.split()[0] == "L":
        right.append(left.pop())
    elif c.split()[0] == "R":
        left.append(right.pop())
    elif c.split()[0] == "D":
        left.pop()

result = left + right[::-1]

return result