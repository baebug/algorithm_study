'''
함수 - 셀프 넘버

d(n) = n + n 의 각 자리수
n 을 d(n)의 생성자라고 하며, 생성자가 없는 숫자를 셀프 넘버라고 한다.
10,000 보다 작거나 같은 셀프 넘버를 한 줄에 출력하는 프로그램을 작성하라.
'''
# 1 로 만들어지는 애들 다 제거 (1이 생성자)
# 1 -> 2 -> 4 -> 8 -> 16 -> 23 -> 28 -> 38 -> 49 -> 62 -> 70 -> 77 -> 91 -> ...
# 남은 친구 중 작은 애로 만들어지는거 다 제외 -> 반복
# 소수 찾는 방식이랑 비슷한데?
def d(n):
    tmp = list(map(int, str(n)))    # 17 -> "17"
    return n + sum(tmp)

def findSelfNum(n):
    arr = list(range(1, n + 1))
    idx = 0
    while idx != len(arr) - 1:
        a = arr[idx]
        while d(a) <= n:
            if d(a) in arr:
                arr.remove(d(a))
                a = d(a)
            else:
                break
        idx += 1
    for i in arr:
        print(i)

findSelfNum(10000)