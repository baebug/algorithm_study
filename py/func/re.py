# isdigit.py 에 정규식 예시

# 문자 클래스 []    :   [] 사이의 문자들과 매치
'''
^ : not
즉, [^0-9]    : 숫자가 아닌 문자만 매치

\d      ==      숫자와 매치         : [0-9]
\D      ==      not 숫자와 매치     : [^0-9]
\s      ==      공백과 매치         : [ \t \n \r \f \v ]
\S      ==      not 공백과 매치     : [^ \t \n \r \f \v ]
\w      ==      숫자 + 문자와 매치   : [a-zA-Z0-9_]
\W      ==      not /w           : [^a-zA-Z0-9_]
'''

# Dot(.)
'''
줄바꿈 문자인 \n 을 제외한 모든 문자와 매치된다.

a.b     == "a + 모든문자 + b"
a[.]b   == "a.b"
'''

# 반복
'''
*       : 바로 앞에 있는 문자가 0부터 무한대까지 반복될 수 있다는 의미이다.

ca*t    == ct, cat, caat, caat, caa...t

+       : 바로 앞에 있는 문자가 최소 1번 이상 반복될 때 사용한다.
ca+t    == cat, caat, caaat, caaa...t

{m, n}  : 바로 앞의 문자가 m 에서 n 회 반복된다는 의미이다.
ca{3}t  == caaat
ca{1,3}t== cat, caat, caaat

?       : 있어도 되고 없어도 된다. {0,1} 과 같은 개념이다.
ca?t    == ct, cat
'''

# re method
'''
import re
p = re.compile('[a-z]+')

match()       : 문자열의 처음부터 정규식과 매치되는지 조사한다.
m = p.match("python")                   # match 객체를 돌려준다. ("python")
m = p.match("3 python")                 # None 을 돌려준다.

search()      : 문자열 전체를 검색하여 정규식과 매치되는지 조사한다.
m = p.search("python")                  # match 객체를 돌려준다. ("python")
m = p.search("3 python")                # match 객체를 돌려준다. ("python")


findall()     : 정규식과 매치되는 모든 문자열을 list 형식으로 돌려준다.
m = p.findall("life is too short")      # ['life', 'is', 'too', 'short']

finditer()    : 정규식과 매치되는 모든 문자열을 반복 가능한 객체로 돌려준다. 각각의 요소는 match 객체이다.
m = p.finditer("life is too short")     # [<match obj>, <match obj>, <match obj>, <match obj>]
'''

# match Object
'''
m = p.search("3 python")

group()       : 매치된 문자열을 돌려준다.
m.group()                               # 'python'

start()       : 매치된 문자열의 시작 위치를 돌려준다.
m.start()                               # 2

end()         : 매치된 문자열의 끝 위치를 돌려준다.
m.end()                                 # 8

span()        : 매치된 문자열의 (시작, 끝)에 해당하는 튜플을 돌려준다.
m.span()                                # (2, 8)
'''

# 컴파일 옵션 (re.M)
'''
import re
p = re.compile("^python\s\w+", re.MULTILINE)

data = """python one
life is too short
python two
you need python
python three"""

print(p.findall(data))

# ['python one', 'python two', 'python three']
'''

# 컴파일 옵션 (re.X)
'''
charref = re.compile(r'&[#](0[0-7]+|[0-9]+|x[0-9a-fA-F]+);')

charref = re.compile(r"""
 &[#]                # Start of a numeric entity reference
 (
     0[0-7]+         # Octal form
   | [0-9]+          # Decimal form
   | x[0-9a-fA-F]+   # Hexadecimal form
 )
 ;                   # Trailing semicolon
""", re.VERBOSE)

[ ] 안의 whitespace는 제외한 문자열에 사용된 whitespace는 컴파일할 때 제거된다.
'''

# 메타문자
'''
|       : or
^       : 문자열의 맨 처음과 일치함을 의미  \A 와 유사 (re.M 에서 다름)
$       : 문자열의 맨 끝과 일치          \Z 와 유사 (re.M 에서 다름)
\b      : 단어 구분자 (보통 whitespace 를 의미), 백스페이스가 아님을 구분하기 위해 반드시 r 과 같이 사용한다. (r'\b')
\B      : \b 와 반대
'''

# 그루핑
'''
()로 그룹을 만든다.
(ABC)+
group(index) 로 지정할 수 있다.
\index 를 통해 재참조 할 수 있다.
'''

# 문자열 바꾸기
'''
re.sub(바꿀 문자열, 대상 문자열, count = n)
count 를 안 쓰면 끝까지 반복

1.  p = [정규식으로 이루어진 찾을 대상]
    p.sub(바꿀 문자열, 대상 문자열, count = n)

2.  new = re.sub(찾을 문자열, 바꿀 문자열, 대상 문자열)
'''

# Non-Greedy
'''
*?      +?      ??      {m,n}?
'''

# 전방 탐색
'''
긍정형 전방 탐색    ?= ...
부정형 전방 탐색    ?! ... 
'''
