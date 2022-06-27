def solution(arr1, arr2):
    y1 = len(arr1)      # 행
    x1 = len(arr1[0])
    
    y2 = len(arr2)
    x2 = len(arr2[0])
    
    # answer = y1 * x2 행렬
    answer = [[0] * x2 for _ in range(y1)]

    for i in range(y1):
        for j in range(x2):
            s = 0
            for k in range(x1):
                s += arr1[i][k] * arr2[k][j]
            answer[i][j] = s
    
    return answer