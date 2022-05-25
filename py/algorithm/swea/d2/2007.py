'''
패턴 마디의 길이

aaaacaaaac... 는 반복 마디의 size 가 5 인데, 내 코드는 1 로 뜬다. (추가적인 검증단계가 필요)
'''

def check(string, n):
    i = 0
    while i < n:
        if string[i] != string[n + i]:
            return False
        i += 1
    return True


def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        str_ = input()
        idx = 0

        while 1:
            idx = str_.index(str_[0], idx + 1)
            if check(str_, idx):
                print(f'#{test_case} {idx}')
                break


if __name__ == '__main__':
    solve()
