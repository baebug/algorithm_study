def solution(land):
    # 자신의 열이 아닌 나머지 열 중 가장 큰 값을 더한다(+=) -> 반복
    n = len(land)
    
    for i in range(1, n):
        land[i][0] += max(land[i-1][1], land[i-1][2], land[i-1][3])
        land[i][1] += max(land[i-1][0], land[i-1][2], land[i-1][3])
        land[i][2] += max(land[i-1][0], land[i-1][1], land[i-1][3])
        land[i][3] += max(land[i-1][0], land[i-1][1], land[i-1][2])
    
    answer = max(land[n - 1])
    
    return answer