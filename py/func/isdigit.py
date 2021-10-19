# https://soooprmx.com/%ed%8c%8c%ec%9d%b4%ec%8d%ac%ec%9d%98-%ec%88%ab%ec%9e%90%ed%8c%90%eb%b3%84%ed%95%a8%ec%88%98/

'''
#   isdigit() vs isnumeric() vs isdecimal()
isdigit() 과 isnumeric() 은 숫자(0-9) 처럼 생긴 특수기호(n제곱, n/m) 도 인정한다.
즉, int 값으로 변환이 가능한 수 자료인지 확인하기 위해ㅓ는 isdecimal() 을 사용하는 것이 옳다.

#   isalpha()
문자열의 구성이 알파벳인지에 대해서 확인하는 방법이다. 숫자 및 공백, 특수문자 등이 포함되어 있으면 False 를 리턴한다.

#   isalnum()
공백 또는 특수문자에 대해서 False 를 리턴한다.
'''

import re
return bool(re.match("^(\d{4}|\d{6})$", s))

# ^ 와 $ 는 문자열 처음과 끝을 의미
# ^(     )$     괄호 속에
# \d{4}|\d{6}   숫자 4개 또는 숫자 6개
