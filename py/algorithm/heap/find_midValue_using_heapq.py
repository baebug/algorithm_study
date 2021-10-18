import heapq

def find_mid(nums) :
    less = []   # 최대힙
    more = []   # 최소힙
    
    result = []
    
    for num in nums:
        # 둘 다 비어있으면
        if not less and not more:
            heapq.heappush(less, -num)
            result.append(-less[0])
        else:
            if num > -less[0]:
                heapq.heappush(more, num)
            else:
                heapq.heappush(less, -num)
            
            if len(less) > len(more) + 1:
                heapq.heappush(more, -heapq.heappop(less))
            if len(less) < len(more):
                heapq.heappush(less, -heapq.heappop(more))
            
            result.append(-less[0])
        
    return result