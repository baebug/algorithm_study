from collections import deque

def BFS(tree) :
    '''
    tree를 너비 우선 탐색으로 순회하여 리스트로 반환하는 함수
    tree 에는 index, left, right 속성이 주어진다.
    '''
    
    dq = deque()
    result = []

    dq.append(tree)
    
    while dq:
        if dq[0].left:
            dq.append(dq[0].left)
        if dq[0].right:
            dq.append(dq[0].right)
            
        result.append(dq.popleft().index)
    
    return result