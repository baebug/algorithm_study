# 한 두줄 입력받는 문제들과 달리, 반복문으로 여러줄을 입력 받아야 할 때는 input() 사용 시 시간초과가 발생할 수 있다.
import sys

# 한 개의 정수를 입력받을 때 (개행문자가 같이 입력 받아지므로 int 형변환 시켜준다.)
a = int(sys.stdin.readline())

# 정해진 개수의 정수를 한 줄에 입력받을 때
a, b, c, ... = map(int, sys.stdin.readline().split())

# 임의의 개수의 자료를 한 줄에 입력받아 리스트에 저장할 때
a, b, c, ... = sys.stdin.readline().split()
# 정수라면? -> map 으로 뜯어서 int 해주고 다시 list 로 변환한다.
a, b, c, ... = list(map(int, sys.stdin.readline().split()))

# 임의의 개수의 정수를 n줄 입력받아 2차원 리스트에 저장할 때
data = []
n = int(sys.stdin.readline())   # 몇 줄 받을 것인지
for i in range(n):
    data.append(list(map(int, sys.stdin.readline().split())))

# 문자열 n줄을 입력받아 리스트에 저장할 때
n = int(sys.stdin.readline())   # 몇 줄 받을 것인지
data = [sys.stdin.readline().strip() for i in range(n)]   # strip 문자 제거, right-rstrip, left-lstrip