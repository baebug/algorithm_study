# 요일 계산
# 문제에서 1월 1일이 금요일이라고 주어졌기 때문에 week 배열은 "FRI" 로 시작한다.

def solution(a, b):
    arr = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    week = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"]
    days = 0
    
    for i in range(a-1):
        days += arr[i]
    days += b - 1
    answer = days % 7
    
    return week[answer]