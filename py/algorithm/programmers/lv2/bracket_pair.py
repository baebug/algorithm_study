# 예외 처리와 마지막 return 을 배우자

def is_pair(s):
    arr = list()    # arr = []
    for c in s:
        if c == '(':
            arr.append(c)

        if c == ')':
            try:
                arr.pop()
            except IndexError:
                return False

    return len(arr) == 0