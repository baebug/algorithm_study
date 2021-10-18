'''
* ndarray.shape : 배열의 각 축(axis)의 크기
* ndarray.ndim : 축의 개수(Dimension)
* ndarray.size : 전체 요소(Element)의 개수
ndarray.dtype : 각 요소(Element)의 타입
ndarray.itemsize : 각 요소(Element)의 타입의 bytes 크기

* np.arange(): N 만큼 차이나는 숫자 생성
* np.linspace(): N 등분한 숫자 생성
* np.ndarray.reshape(): 데이터는 그대로 유지한 채 차원을 쉽게 변경

* sum, min, max, argmax, cumsum, slicing, indexing 등 list 의 기능 대부분 지원
'''
import numpy as np
import numpy.random as npr

A = [[1,2], [2,3]]
B = [[3,4], [5,6]]

A = np.array(A)
B = np.array(B)
answer = A + B
# [[4 6]
#  [7 9]]
answer = answer.tolist()

print(answer)
'''
import numpy as np
def sumMatrix(A,B):
    A=np.array(A)
    B=np.array(B)
    answer=A+B
    return answer.tolist()

print(sumMatrix([[1,2], [2,3]], [[3,4],[5,6]]))
'''
