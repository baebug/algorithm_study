'''
1974 - 스도쿠 검증
'''

def check_row(row):
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    for i in row:
        if i in arr:
            arr.remove(i)
        else:
            return False
    return True


def check_3x3(arr):
    tmp = []

    for r in arr:
        tmp += r
    
    if check_row(tmp):
        return True
    else:
        return False

def check_9x9(arr):
    cnt = 0

    for r in arr:
        if check_row(r):
            cnt += 1
    
    for r in rotate(arr):
        if check_row(r):
            cnt += 1
    
    for i in range(3):
        for j in range(3):
            tmp = []
            for k in range(3*i, 3*(i+1)):
                tmp.append(arr[k][3*j:3*(j+1)])
            if check_3x3(tmp):
                cnt += 1
    
    if cnt == 27:
        return True
    else:
        return False


def rotate(arr):
    return [list(r) for r in zip(*arr[::-1])]


t = int(input())


for test_case in range(1, t+1):
    arr = []
    ans = 0

    for _ in range(9):
        arr.append(list(map(int, input().split())))

    if check_9x9(arr):
        ans = 1

    print(f'#{test_case} {ans}')