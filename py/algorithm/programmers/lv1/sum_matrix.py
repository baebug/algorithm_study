# 1
'''
import numpy as np
def sumMatrix(A,B):
    A=np.array(A)
    B=np.array(B)
    answer=A+B
    return answer.tolist()

print(sumMatrix([[1,2], [2,3]], [[3,4],[5,6]]))
'''
# 2
'''
def sumMatrix(A,B):
    answer = [[c + d for c, d in zip(a, b)] for a, b in zip(A,B)]
    return answer

print(sumMatrix([[1,2], [2,3]], [[3,4],[5,6]]))
'''
# 3
'''
def sumMatrix(A,B):
    return [list(map(sum, zip(*x))) for x in zip(A, B)]

print(sumMatrix([[1,2], [2,3]], [[3,4],[5,6]]))
'''

