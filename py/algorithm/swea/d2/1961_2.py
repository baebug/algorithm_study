'''
숫자 배열 회전

# zip 을 이용해서 어쩌고.. (행렬의 성질 이용)
- https://velog.io/@shelly/python-zip-%EC%9C%BC%EB%A1%9C-%EB%B0%B0%EC%97%B4-%ED%9A%8C%EC%A0%84
- https://choichumji.tistory.com/74

'''
def rotate(arr):
    return [list(i) for i in zip(*arr[::-1])]


def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        n = int(input())
        arr = []
        for _ in range(n):
            arr.append((list(map(int, input().split()))))

        r1 = rotate(arr)
        r2 = rotate(r1)
        r3 = rotate(r2)

        print(f'#{test_case}')
        for i in range(n):
            for j in range(n):
                print(r1[i][j], end="")
            print(" ", end="")
            for j in range(n):
                print(r2[i][j], end="")
            print(" ", end="")
            for j in range(n):
                print(r3[i][j], end="")
            print("")        


if __name__ == '__main__':
    solve()
