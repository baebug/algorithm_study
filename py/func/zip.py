# https://www.daleseo.com/python-zip/
'''
zipper 처럼 두 그룹의 데이터를 서로 엮어줘서 zip() 이다.

for i in zip(numbers, letters):         for i in range(3):
    print(i)                                print(numbers[i], letters[i])

'''
for number, upper, lower in zip("12345", "ABCDE", "abcde"):
    print(number, upper, lower)

# 1 A a
# 2 B b
# 3 C c
# 4 D d
# 5 E e

keys = [1, 2, 3]
values = ["A", "B", "C"]
dict(zip(keys, values))
# {1: 'A', 2: 'B', 3: 'C'}

A = [[1,2], [2,3]]
B = [[3,4], [5,6]]

for a, b in zip(A,B):           # ([1, 2], [3, 4]), ([2, 3], [5, 6])
    for c, d in zip(a, b):      # (c, d) = (1, 3), (2, 4), (2, 5), (3, 6)
        c + d                   # c + d = 4, 6, 7, 9

'''
def sumMatrix(A,B):
    answer = [[c + d for c, d in zip(a, b)] for a, b in zip(A,B)]
    return answer

print(sumMatrix([[1,2], [2,3]], [[3,4],[5,6]]))
'''

'''
def sumMatrix(A,B):
    return [list(map(sum, zip(*x))) for x in zip(A, B)]

print(sumMatrix([[1,2], [2,3]], [[3,4],[5,6]]))
'''