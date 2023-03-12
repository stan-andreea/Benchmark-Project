import org.python.util.PythonInterpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Controller {
    private final Benchmark view = new Benchmark();

    public Controller() {
        view.addStaticMemoryAllocationBtnListener(new StaticMemoryAllocationBtnListener());
        view.addDynamicMemoryAllocationBtnListener(new DynamicMemoryAllocationBtnListener());
        view.addStaticMemoryAccessBtnListener(new StaticMemoryAccessBtnListener());
        view.addDynamicMemoryAccessBtnListener(new DynamicMemoryAccessBtnListener());
        view.addThreadCreationBtnListener(new ThreadCreationBtnListener());
        view.addThreadContextSwitchBtnListener(new ThreadContextSwitchBtnListener());
        view.addThreadMigrationBtnListener(new ThreadMigrationBtnListener());
    }

    public String runExec(String command, String filename) {
        String value = "";
        try {
            Runtime.getRuntime().exec(command);
            FileInputStream file = new FileInputStream(filename);
            Scanner fin = new Scanner(file);
            if (fin.hasNext()) {
                value = fin.next();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public String runPython(String command, String filename) {
        String value = "";
        try {
            PythonInterpreter pythonInterpreter = new PythonInterpreter();
            pythonInterpreter.execfile(command);

            FileInputStream file = new FileInputStream(filename);
            Scanner fin = new Scanner(file);
            if (fin.hasNext()) {
                value = fin.next();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }


    public String readFromFile(String filename){
        String value = "";
        FileInputStream file = null;
        try {
            file = new FileInputStream(filename);
            Scanner fin = new Scanner(file);
            if (fin.hasNext()) {
                value = fin.next();
            }
            file.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return value;
    }


    private class StaticMemoryAllocationBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cValue = runExec("./memAllocStatic.exe", "memAllocStatic.txt");
            String pythonValue = runExec("./PyMemAlloc.exe", "PyMemAllocSt.txt");
            memAll();
            String javaValue = readFromFile("JVMemAllocSt.txt");


            view.setStaticMemoryAllocationText(cValue,javaValue, pythonValue);

        }
    }

    private class DynamicMemoryAllocationBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cValue = runExec("./memAllocDynamic.exe", "memAllocDynamic.txt");
            String pythonValue = runExec("./PyMemAlloc.exe", "PyMemAllocDyn.txt");
            memAll();
            String javaValue = readFromFile("JVMemAllocDn.txt");

            view.setDynamicMemoryAllocationText(cValue,javaValue, pythonValue);

        }
    }

    private class StaticMemoryAccessBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cValue = runExec("./memAccStatic.exe", "memAccStatic.txt");
            String pythonValue = runExec("./PyMemAcc.exe", "PyMemAccSt.txt");

            memAcc();
            String javaValue = readFromFile("JVMemAccS.txt");

            view.setStaticMemoryAccessText(cValue,javaValue, pythonValue);

        }
    }

    private class DynamicMemoryAccessBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cValue = runExec("./memAccDynamic.exe", "memAccDynamic.txt");
            String pythonValue = runExec("./PyMemAcc.exe", "PyMemAccDn.txt");

            memAcc();
            String javaValue = readFromFile("JVMemAccDn.txt");

            view.setDynamicMemoryAccessText(cValue,javaValue, pythonValue);

        }
    }

    private class ThreadCreationBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cValue = runExec("threadCreation.exe", "threadCreation.txt");
            String pythonValue = runExec("./PyThreadCreate.exe", "PyThreadCreate.txt");

            threadCr();
            String javaValue = readFromFile("JVThreadCreate.txt");
            view.setThreadCreationText(cValue,javaValue, pythonValue);

        }
    }

    private class ThreadContextSwitchBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cValue = runExec("./threadContextSwitch.exe", "threadContextSwitch.txt");
            System.out.println(cValue);
            String pythonValue = runExec("./PyThreadSW.exe", "PyThreadSw.txt");

            threadSw();
            String javaValue = readFromFile("JVThreadSwitch.txt");
            view.setThreadContextSwitchText(cValue,javaValue, pythonValue);

        }
    }

    private class ThreadMigrationBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cValue = runExec("threadMigration.exe", "threadMigration.txt");
            String pythonValue = runExec("./PyThreadMigration.exe", "PyThreadMigration.txt");

            try {
                threadMig();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            String javaValue = readFromFile("JVThreadMigration.txt");
            System.out.println(javaValue);
            view.setThreadMigrationText(cValue,javaValue, pythonValue);

        }
    }


    public void memAcc(){
        MemAcc memAcc = new MemAcc();
        double startTime = System.nanoTime();

        memAcc.acc();

        double endTime = System.nanoTime();
        double diff = endTime - startTime;
        double executionTimeS =diff/1000000;

        DecimalFormat df = new DecimalFormat("#.#####");

        try {
            FileWriter myWriter = new FileWriter("JVMemAccS.txt");
            myWriter.write(String.valueOf(df.format(executionTimeS)));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        Object[] array = new Object[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            array[i] = new Object();
        }

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            array[i] = new Object();
        }
        endTime = System.nanoTime();
        diff = endTime - startTime;
        double executionTimeD =diff/1000000;

        try {
            FileWriter myWriter = new FileWriter("JVMemAccDn.txt");
            myWriter.write(String.valueOf(df.format(executionTimeD)));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void memAll(){
        MAlloc mAlloc = new MAlloc();
        mAlloc.print();

        long startTime = System.nanoTime();
        MAllocD mAllocD = new MAllocD();
        long endTime = System.nanoTime();
        double diff = endTime - startTime;
        double executionTime =diff/100000;

        DecimalFormat df = new DecimalFormat("#.#####");

        try {
            FileWriter myWriter = new FileWriter("JVMemAllocDn.txt");
            myWriter.write(String.valueOf(df.format(executionTime)));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void threadCr(){
        Thr thr = new Thr();
        double startTime = System.nanoTime();


        Thread t1 = new Thread(thr);


        double endTime = System.nanoTime();
        double diff = endTime - startTime;
        double executionTime =diff;
        t1.start();
        DecimalFormat df = new DecimalFormat("#.#####");

        try {
            FileWriter myWriter = new FileWriter("JVThreadCreate.txt");
            myWriter.write(String.valueOf((df.format(executionTime/1000000))));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void threadSw(){
        Resource resource = new Resource();
        ThrSwitch thrSwitch = new ThrSwitch(resource);
        ThrSwitch thrSwitch1 = new ThrSwitch(resource);
        double startTime = System.nanoTime();

        thrSwitch.run();
        thrSwitch1.run();


        double endTime = System.nanoTime();
        double diff = endTime - startTime;
        double executionTime =diff/1000000;

        DecimalFormat df = new DecimalFormat("#.#####");

        try {
            FileWriter myWriter = new FileWriter("JVThreadSwitch.txt");
            myWriter.write(String.valueOf(df.format(executionTime)));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void threadMig() throws InterruptedException {
        double[] migration_times = new double[Runtime.getRuntime().availableProcessors()];
        int min_priority = Thread.MIN_PRIORITY;
        int max_priority = Thread.MAX_PRIORITY;
        for (int i = 0; i < migration_times.length; i++) {
            long start_time = System.nanoTime();
            Thread thread = new Thread(() -> {
                // do some work here
            });
            thread.setPriority(min_priority + (i * (max_priority - min_priority) / migration_times.length));
            thread.start();
            thread.join();
            long end_time = System.nanoTime();
            migration_times[i] = end_time - start_time;
            TimeUnit.MILLISECONDS.sleep(100);
        }
        double time = 0;
        for (int i = 0; i < migration_times.length; i++) {
            time += migration_times[i];
        }

        time/=1000000;
        try {
            FileWriter myWriter = new FileWriter("JVThreadMigration.txt");
            myWriter.write(String.valueOf(time/(migration_times.length)));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
