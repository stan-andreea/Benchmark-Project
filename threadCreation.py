from time import process_time
from threading import Thread

n = 1000
# Start all threads.
threads = []
start = process_time()
for n in range(n):
    t = Thread(target=None, args=(None,))
    t.start()
    threads.append(t)

end = process_time()


# Wait all threads to finish.
for t in threads:
    t.join()

executionTime = end - start;
f = open("PyThreadCreate.txt", "w")
f.write(str(executionTime))







