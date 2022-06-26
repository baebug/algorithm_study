'''
정렬 - 수 정렬하기 3

카운팅 정렬 (수의 범위가 작을 때 효과적이다.)

input 1000만개를 담으면 메모리 터진다.
output 도 그러면 담아서 출력하면 안 된다고?
'''
import sys

input = sys.stdin.readline
print = sys.stdout.write

def main():
    N = int(input())

    arr = [0] * 10001  # idx 가 0 부터 10000 까지

    for _ in range(N):
        arr[int(input())] += 1

    for i in range(len(arr)):
        if arr[i]:
            while arr[i] > 1000:
                print((str(i) + '\n') * 1000)
                arr[i] -= 1000
            print((str(i) + '\n') * arr[i])

if __name__ == "__main__":
    main()