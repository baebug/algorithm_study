# 10진수에서 2진수, 8진수, 16진수 변환
value = 60

b = bin(value)  # 0b111100
o = oct(value)  # 0o74
h = hex(value)  # 0x3c

b = format(value, '#b') # 0b111100
o = format(value, '#o') # 0o74
h = format(value, '#x') # 0x3c

b = format(value, 'b') # 111100
o = format(value, 'o') # 74
h = format(value, 'x') # 3c


# 다른 진수 형태에서 10진수로 변환

b = int('0b111100', 2)  # 60
o = int('0o74', 8)      # 60
h = int('0x3c', 16)     # 60