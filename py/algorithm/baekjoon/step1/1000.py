# 1 2 이런 식으로 더할 두 수가 입력된다.
# input().split() 을 하면 입력받은 데이터는 [num1, num2] 이런 식으로 array 형태를 갖게 되는데
# input 으로 입력받은 데이터는 str 이므로 int 로 바꿔주는 작업이 필요하다.

inputArr = input().split()
a = int(inputArr[0])
b = int(inputArr[1])
print(a + b)
# a = int(input().split()[0])
# b = int(input().split()[0])
# 이런 식으로 작성하면 input() 을 계속 받는다.
# input() 받은 결과가 아니라 그때그때 input func 을 실행

# 정답 코드
# a, b = map(int, input().split())
# print(a+b)