import threading
import psutil
from time import process_time

def thread_func(thread_id):
    print(f"Hello from thread {thread_id}")

if __name__ == "__main__":
    # Create two threads
    thread1 = threading.Thread(target=thread_func, args=(1,))
    thread2 = threading.Thread(target=thread_func, args=(2,))

    start = process_time()


    for i in range(1000):
        # Migrate thread 1 to CPU 0
        p = psutil.Process(thread1.ident)
        p.cpu_affinity([0])

        # Migrate thread 2 to CPU 1
        p = psutil.Process(thread2.ident)
        p.cpu_affinity([1])



    thread1.start()
    thread2.start()

    # Wait for the threads to finish
    thread1.join()
    thread2.join()
    end = process_time()

    executionTime = end - start

    f = open("PyThreadMigration.txt", "w")
    f.write(str(executionTime))


    print("Execution time for thread migration is ", executionTime, " ^ 10^(-3)");
