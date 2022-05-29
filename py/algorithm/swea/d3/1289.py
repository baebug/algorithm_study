'''
원재의 메모리 복구하기
'''

def solve():
    t = int(input())

    for test_case in range(1, t+1):
        data = input()
        new = ''
        tmp = '0'
        count = 0

        for i in data:
            if i == tmp:
                new += tmp
            else:
                if tmp == '0':
                    tmp = '1'
                elif tmp == '1':
                    tmp = '0'
                new += tmp
                count += 1

        print(f'#{test_case} {count}')


if __name__ == '__main__':
    solve()

