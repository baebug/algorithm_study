'''
파스칼의 삼각형
'''

def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        n = int(input())
        arr = [[1]]

        if n == 1:
            pass
        else:
            for i in range(1, n):
                tmp = []
                idx = 0
                for j in range(i + 1):
                    if idx == 0 or idx == i:
                        tmp.append(1)
                    else:
                        tmp.append(arr[i-1][j-1] + arr[i-1][j])
                    idx += 1
                arr.append(tmp)

        print(f'#{test_case}')
        for r in arr:
            print(*r)


if __name__ == '__main__':
    solve()
