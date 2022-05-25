'''
초심자의 회문 검사
'''

def check(word):
    word2 = word[::-1]
    n = len(word)
    i = 0

    while i < n:
        if word[i] != word2[i]:
            return 0
        i += 1
    return 1


def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        word = input()

        print(f'#{test_case}', check(word))


if __name__ == '__main__':
    solve()
