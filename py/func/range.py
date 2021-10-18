'''
range(a, b, c)
a: start (default: 0)
b: stop
c: step (default: 1)

range() 함수의 결과는 iterable 하기 때문에 for 문을 사용해 출력할 수 있다.
'''
range(10)
# range(0, 10)

a = list(range(10))
# [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

a = list(range(0, 20, 2))
# [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]

print(a)