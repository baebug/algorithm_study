'''
두 정수 a, b 를 입력받아 다음과 같은 정사각형을 만들어라.
3 5
    *****
    ***** 
    *****
'''
# 내가 짠 코드
for i in range(a):
    for j in range(b):
        print("*", end="")
    print()

# 줏어온 코드
print(("*" * b + '\n') * a)

'''
문자열, 배열의 곱셉(을 포함한 사칙연산)을 잘 이용하자.
'''
