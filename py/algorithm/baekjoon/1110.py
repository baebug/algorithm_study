# ver.1 (21.10.14) - 개선의 여지가 많음

num = input()

def add_digits(i):
    if int(i) < 10:
        i = "0" + str(int(i))
    
    newNum = str(int(i[0]) + int(i[1]))

    if int(newNum) < 10:
        newNum = "0" + str(int(newNum))
    
    return i[1] + newNum[1]  

count = 1
newNum = add_digits(num)

while 1:
    if int(newNum) == int(num):
        print(count)
        break
    else:
        count += 1
        newNum = add_digits(newNum)

# print(newNum)
