'''
Tree 에 depth 속성을 추가해주었다.
'''
def inorder(tree, depth):
    result = []
    
    if tree.left != None:
        result += inorder(tree.left, depth + 1)

    tree.setDepth(depth)
    result.append(tree)
    
    if tree.right != None:
        result += inorder(tree.right, depth + 1)
    
    return result


def getWidth(myTree) :
    '''    
    반환값 형식 : (level, width)
    '''
    
    result = inorder(myTree, 1)
    n = len(result)
    
    # 정점의 개수는 1000개 이하이다. (입력 조건)
    # 깊이의 최댓값은 1000 (편향)
    
    # left[i] => 깊이가 i인 모든 노드들 중 가장 왼쪽에 있는 노드의 행
    left = [1001 for i in range(1001)]
    # right[i] => 깊이가 i인 모든 노드들 중 가장 오른쪽에 있는 노드의 행
    right = [-1 for i in range(1001)]
    maxDepth = 0
    
    for i in range(n):
        d = result[i].depth
        
        left[d] = min(left[d], i)
        right[d] = max(right[d], i)
        
        maxDepth = max(maxDepth, d)
    
    ansDepth = 0
    ans = 0
    
    for i in range(1, maxDepth + 1):
        tmp = right[i] - left[i] + 1
        
        if ans < tmp:
            ansDepth = i
            ans = tmp
    
    return (ansDepth, ans)