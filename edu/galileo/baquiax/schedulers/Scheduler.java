package edu.galileo.baquiax.schedulers;
import edu.galileo.baquiax.process.AnyProcess;
import edu.galileo.baquiax.process.Process;
import java.util.List;
public abstract class Scheduler implements Runnable {
    private List<Process> readyQueue;
    private List<Process> waitQueue;
    private List<Process> finishedQueue;
        
    abstract AnyProcess getNextProcess();
    abstract void newProcess(Process p);
    abstract void sleepProcess(Process p);
    abstract void wakeProcess(Process p);
    
}