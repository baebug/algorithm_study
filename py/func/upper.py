# string.upper() 는 string 내부의 문자들을 모두 각각 대문자로 변환해서 새로운 문자열을 반환합니다. 절대 s1이 바뀌는게 아니다.

s = "abcd"
s.upper()
print(s)                # abcd
print(s.upper())        # ABCD
print(s.capitalize())   # Abcd