'''
땅따먹기
개무식하게 푼 방법도 있지만 채점 다 통과못하고, 시간초과까지. (밑에 첨부함)

0, 1, 2, 3 저렇게 직접 적어줄 줄은 몰라따. 먼가 습관성 for문,,
지금 층의 땅 value 에 이전 층의 최고값을 더하면서 끝까지 가고, max 를 출력
'''
def solution(land):
    # land 가 [[a, b, c, d], [e, f, g, h], [h, i, j, k], ...] 이렇게 들어온다.
    # max(land[i]) 를 더해주면 되는데 이전에 밟은 열은 못 밟는 특수 규칙이 있다.
    # max(land[i]) 와 max(land[i + 1]) 의 index 가 겹치면 ... 머가 더 이득인지 비교해야 하는데 이게 맞나?
    
    # 그냥 배제하면서 모든 케이스 비교 (가방문제) 가 나을듯.
    
    l = len(land)   # 일단 3이라고 생각하자. (0, 1, 2층)
    
    for i in range(1, l):
        land[i][0] += max(land[i - 1][1], land[i - 1][2], land[i - 1][3])
        land[i][1] += max(land[i - 1][0], land[i - 1][2], land[i - 1][3])
        land[i][2] += max(land[i - 1][0], land[i - 1][1], land[i - 1][3])
        land[i][3] += max(land[i - 1][0], land[i - 1][1], land[i - 1][2])
    
    return max(land[l - 1])

print(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1]]))


'''
import copy

def solution(land):
    answer = 0

    l = len(land)   # 일단 3이라고 생각하자.
    arr = []
    for s in range(4):
        _land = copy.deepcopy(land)
        sum = _land[0][s]
        _land[1][s] = -1 # 끝나면 돌려줘야 하는데 이게 안되네 -> deepcopy로 해결
        for i in range(1, l):
            sum += max(_land[i])
            if i < l - 1:
                _land[i + 1][_land[i].index(max(_land[i]))] = -1
        arr.append(sum)
        
    answer = max(arr)
    
    return answer

print(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1]]))
'''