def test(n):
    return n + n

numbers1 = 1, 2, 3, 4
numbers2 = 3, 4, 5, 6

# test() all numbers using map
result = map(test, numbers1)
print(list(result)) # distinct

# Double all numbers using map and lambda
result = map(lambda x: x + x, numbers1)
print(list(result))

# Add two lists using map and lambda
result = map(lambda x, y: x + y, numbers1, numbers2)
print(list(result))

# map(func, array)
# map 이 for ... in 처럼 대상 array 의 모든 element 에 대해 func 작업을 수행하는데
# lambda 를 사용하여 i 를 나타낼 수 있다. (i + i, i * 2 등의 작업 가능)
