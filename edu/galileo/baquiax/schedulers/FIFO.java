package edu.galileo.baquiax.schedulers;
import edu.galileo.baquiax.Machine;
import edu.galileo.baquiax.process.Process;
import edu.galileo.baquiax.process.IdleProcess;
import java.util.LinkedList;

public class FIFO extends Scheduler {
    
    public FIFO() {
        this.readyQueue = new LinkedList<Process>();
        this.waitQueue = new LinkedList<Process>();
        this.finishedQueue = new LinkedList<Process>(); 
    }
        
    @Override
    public Process getNextProcess() {
        if (this.readyQueue.size() == 0 ) {
            return new IdleProcess();
        }
    }
    
    @Override
    public void newProcess(Process p) {        
        notify(); //Need improvement
        
    }
    
    @Override
    public void sleepProcess(Process p) {
        
    }
    
    @Override
    public void wakeProcess(Process p);              
    
    @Override
    public void run() {
        if (readyQueue.size() == 0) wait();        
        while(true) {
            
        }
    }
}