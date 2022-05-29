'''
[S/W 문제해결 기본] 8일차 - 암호문3
'''

def solve():
    t = 10

    for test_case in range(1, t+1):
        n = int(input())
        arr = list(map(int, input().split()))
        m = int(input())
        commands = input().split()
        
        for idx, c in enumerate(commands):
            if c == 'I':
                st = int(commands[idx + 1])
                i = int(commands[idx + 2])
                data = list(map(int, commands[idx+3:idx+3+i]))
                for i, d in enumerate(data):
                    arr.insert(st+i, d)
            elif c == 'D':
                st = int(commands[idx + 1])
                i = int(commands[idx + 2])
                for _ in range(i):
                    arr.pop(st)
            elif c == 'A':
                i = int(commands[idx + 1])
                data = list(map(int, commands[idx+2:idx+2+i]))
                for d in data:
                    arr.append(d)

        print(f'#{test_case}', *list(arr[:10]))


if __name__ == '__main__':
    solve()

