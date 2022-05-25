'''
간단한 369 게임
'''

def has369(i):
    tmp = list(map(int, str(i)))

    if (3 in tmp) or (6 in tmp) or (9 in tmp):
        return True
    return False


def clap(i):
    tmp = list(map(int, str(i)))
    count = tmp.count(3) + tmp.count(6) + tmp.count(9)

    return count


def solve():
    n = int(input())

    for i in range(1, n+1):
        if has369(i):
            print('-' * clap(i), end=" ")
        else:
            print(i, end=" ")


if __name__ == '__main__':
    solve()
