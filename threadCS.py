import threading
import time
from time import process_time

def worker1():
    lock.acquire()
    time.sleep(0.01) # simulate some work
    lock.release()

def worker2():
    lock.acquire()
    time.sleep(0.01) # simulate some work
    lock.release()

lock = threading.Lock()

start = process_time()

for i in range(100):
    t1 = threading.Thread(target=worker1)
    t2 = threading.Thread(target=worker2)
    t1.start()
    t2.start()
    t1.join()
    t2.join()

end = process_time();

executionTime = end - start;
f = open("PyThreadSw.txt", "w")
f.write(str(executionTime))




