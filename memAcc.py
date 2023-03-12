from time import process_time

n= 1000000

x = 12

start = process_time()

for i in range (n):
    b = id(x)

end = process_time()

executionTime = end - start
f = open("PyMemAccSt.txt", "w")
f.write(str(executionTime))

a = [0] * 10000000
for i in range (n):
    a[i] = b

f = open("PyMemAccDn.txt", "w")
f.write(str(executionTime))


