package edu.galileo.baquiax.schedulers;
import edu.galileo.baquiax.Machine;
import edu.galileo.baquiax.process.*;
import java.util.LinkedList;

public class FIFO extends Scheduler {
    
    public FIFO() {
        this.readyQueue = new LinkedList<Process>();
        this.waitQueue = new LinkedList<WaitingProcess>();
        this.finishedQueue = new LinkedList<Process>(); 
    }
        
    @Override
    public AnyProcess getNextProcess() {
        if (this.readyQueue.size() == 0 ) {
            return new IdleProcess();
        } else {
            return this.readyQueue.peek();
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
    public void wakeProcess(Process p) {
        
    }
    
    @Override
    public void run() {
        if (readyQueue.size() == 0) wait();        
        while(true) {
            AnyProcess ap = getNextProcess();
            if (p.isSubClassOf(Process.class)) {
                Process p = (Process) ap;
                Burst b = p.getNextBurst();
                if (b && b.getType() == Burst.BurstType.IO) {
                    this.readyQueue.remove(p);
                    this.waitQueue.add(new WaitingProcess(p, ))            
                } else {
                    p.workInProcess(p.getNextBurstTime());
                }                
            }
        }
    }
}