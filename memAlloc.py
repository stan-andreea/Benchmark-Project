from time import process_time
n = 1000000

start = process_time()

for i in range (n):
    b = []

end = process_time()

executionTime = end - start
f = open("PyMemAllocSt.txt", "w")
f.write(str(executionTime))

start = process_time()
a = [0] * 10000000
end = process_time()

f = open("PyMemAllocDyn.txt", "w")
f.write(str(executionTime))

executionTime = end - start


