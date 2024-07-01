package com.codecounty.java.advance.multithreading.multithreading_by_defog.basics.synchronization_problem;



/* Example showing multiple threads executing the same synchronized method*/

class LineSync
{
    // multiple threads(students) can access this synchronized method
    // but only one thread can access it at a time
    synchronized public void getLine()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println(i);
            try
            {
                Thread.sleep(400);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

class StudentSync extends Thread
{
    // reference to Line's Object.
    LineSync line;

    StudentSync(LineSync line)
    {
        this.line = line;
    }

    @Override
    public void run()
    {
        line.getLine();
    }
}

class ExampleSynchronized
{
    public static void main(String[] args)
    {
        // Object of Line class that is shared
        // among the threads.
        LineSync obj = new LineSync();

        // creating the threads that are
        // sharing the same Object.
        StudentSync student1 = new StudentSync(obj);
        StudentSync student2 = new StudentSync(obj);

        // threads start their execution.
        student1.start();
        student2.start();
    }
}
