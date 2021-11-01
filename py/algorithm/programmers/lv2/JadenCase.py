# split() 가 아니라 split(" ") 를 쓰는게 포인트.
# s = "a b   c"
# s.split() --> ['a', 'b', 'c']
# s.split(" ") --> ['a', 'b', '', '', 'c']

# string.capitalize()

s = "3people unFollowed  me"
answer = " ".join([x.capitalize() for x in s.split(" ")])
