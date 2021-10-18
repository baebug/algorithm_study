
def evenOrOdd(num):
    return ["Even", "Odd"][num & 1]

# 짝수면 0, 홀수면 1 이 출력된다.
# 짝수는 2진법으로 표기시 끝이 0 이기 때문에 bit 의 and 연산자가 False 를 뱉음.
# 반대로 홀수는 1 이기 때문에 True 가 나온다.

print(evenOrOdd(12842739486))