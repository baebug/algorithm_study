'''
최빈수 구하기

# sort with lambda https://h-sseung.tistory.com/55
# Counter https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=wideeyed&logNo=221540885097

라이브러리를 안 쓴다면 어떻게 풀 것인가?
dict 만들어서?
'''

def solve():
    t = int(input())

    for test_case in range(1, t + 1):
        n = int(input())
        result = {}
        arr = map(int, input().split())

        for i in arr:
            if i in result:
                result[i] += 1
            else:
                result[i] = 1

        m = max(result.values())
        m_ = max([k for k, v in result.items() if v == m])
        print(f'#{test_case} {m_}')


if __name__ == '__main__':
    solve()
