package edu.galileo.baquiax.process;
import java.util.LinkedList;

public class WaitingProcess extends AnyProcess {
    private Process process;
    private int indexInScheduler;
        
    public WaitingProcess(Process p, int index) {
        this.process = p;
        this.indexInScheduler = index;
    }
    
    public Process getProcess() {
        return this.process;
    }
    
    public int getIndexInScheduler() {
        return this.indexInScheduler;
    }
}