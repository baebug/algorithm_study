arr, tmp =[]
index, a, b, item = 0

# 정렬
arr.sort()
arr.sort(reverse=True)
arr.reverse()

# 요소를 지우는 방법 (하나만 지움)
del arr[index]
del arr[a:b]

arr.remove(item)
del arr[arr.index(item)]

# sum, min, max 를 지원한다! 무친!

(sum(range(10))) # 45 이딴것도 작동한다.

# map, filter ( function , arr )
# map, filter ( lambda x: func(x) , arr )

# list comp..rehension
print([n for n in arr if n > 10] or [-1])

# 주어진 리스트를 받아 3의 배수만 담는 리스트를 만들어봅시다.
_list = [i for i in tmp if i % 3 == 0]

# 주어진 리스트를 그대로 담되, 15가 넘어가는 값은 15로 바꿔서 저장합시다.
_list = [i if i <= 15 else 15 for i in tmp]

# 값을 찾기 위해 list 에서 in 을 사용하면 죽는다. (순차적으로 탐색)
data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
_data_set = set(data)

for i in range(100):
    if i in data:
        print(1)

# * 을 사용해 언패킹 할 수 있다.