test = {}

test[3] = "test"
test["test"] = 12
test[(1, 2, 3)] = [3, 4, 5]

if (1, 2, 4) in test:
    print("있어")
else:
    print("없어")

print((1, 2, 4) in test)
