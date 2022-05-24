'''
간단한 압축 풀기
'''

t = int(input())

for test_case in range(1, t + 1):
    n = int(input())
    str_ = ''
    for _ in range(n):
        a, b = input().split()
        str_ += a * int(b)

    print(f'#{test_case}')

    for i in range(len(str_)):
        print(str_[i], end="")
        if (i + 1) % 10 == 0:
            print("")
    print("")