'''
스도쿠 검증

내가 만들었지만 진짜 잘 만든 것 같다... ㅎ
좀 더 리팩토링 가능함
'''

from collections import Counter


def rotate(arr9x9):
    return [list(i) for i in zip(*arr9x9[::-1])]


def check_line(arr1x9):
    m = Counter(arr1x9).most_common(1)
    if m[0][1] >= 2:
        return False
    else:
        return True


def check_sudoku(arr9x9):
    for i in arr9x9:
        if not(check_line(i)):
            return False
    return True


def check_3x3(arr9x9):
    for n in range(3):
        for m in range(3):
            tmp = []
            for i in range(3 * n, 3 * (n+1)):
                for j in range(3 * m, 3 * (m+1)):
                    tmp.append(arr9x9[i][j])

            if not(check_line(tmp)):
                return False
    return True


def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        sudoku = []
        for i in range(9):
            arr = list(map(int, input().split()))
            sudoku.append(arr)

        if check_sudoku(sudoku) and check_sudoku(rotate(sudoku)) and check_3x3(sudoku):
            print(f'#{test_case} 1')
        else:
            print(f'#{test_case} 0')


if __name__ == '__main__':
    solve()


