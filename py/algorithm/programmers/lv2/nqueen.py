# 검증 로직
def check(x):
    for i in range(x):
        if arr[i] == arr[x] or abs(i - x) == abs(arr[i] - arr[x]):
            return False
    return True

# nqueen
def nqueen(x):
    global cnt
    
    if x == n:
        cnt += 1
        return
    else:
        for i in range(n):
            arr[x] = i

            if check(x):
                nqueen(x + 1)

n = int(input())
arr = [0] * n
cnt = 0

nqueen(0)

print(cnt)