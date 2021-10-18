# https://crackerjacks.tistory.com/14
'''
list, set, dict 자료형은 mutable 하기 때문에 얕은 복사가 이루어진다. 
이는 객체를 새로운 객체로 복사하지만 같은 주소값을 참조하고 있다.

때문에 원본 자료형을 건드리면 안되는 문제에서 깊은 복사를 따로 해주어야 하는데 이를 위한 방법을 알아보자.
'''

# copy 모듈의 deepcopy() 이용
import copy

a = [1, 2, 3, 4]
b = copy.deepcopy(a)


# list 클래스가 기본적으로 가지고 있는 copy() 함수 이용
# 이중 이상의 배열에 대해 완전한 깊은 복사가 이루어지지 않는 단점이 있다.
a = [1, 2, 3, 4]
b = a.copy()


# list 를 생성할 때 매개변수에 원본을 전달, 혹은 생성 후 원본 리스트를 확장
a = [1, 2, 3, 4]
b = list(a)
c = []
c.extend(a)


# 리스트 슬라이싱
# 이 방법 또한 copy()와 마찬가지로 이중 이상의 배열에 대해 완전한 깊은 복사가 이루어지지 않는 단점이 있다.
a = [1, 2, 3, 4]
b = a[:]


# 배열 요소에 접근하여 복사를 진행
a = [1, 2, 3, 4]
b = [i for i in a]

c = []
for i in range(len(a)):
    c.append(a[i])

d = []
for item in a:
    d.append(item)