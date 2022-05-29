'''
최장 경로
'''


def dfs(idx, cnt):
    global ans
    visited[idx] = 0
    cnt += 1

    if cnt > ans:
        ans = cnt

    for j in graph[idx]:
        if visited[j]:
            dfs(j, cnt)

    visited[idx] = 1


t = int(input())

for test_case in range(1, t+1):
    n, m = map(int, input().split())
    tmp = [list(map(int, input().split())) for _ in range(m)]
    ans = 0

    visited = [1 for _ in range(n+1)]
    graph = [[] for _ in range(n+1)]

    for a, b in tmp:
        graph[a].append(b)
        graph[b].append(a)

    for i in range(n):
        dfs(i, 0)

    print(f'#{test_case} {ans}')
