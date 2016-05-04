package edu.galileo.baquiax.process;
import java.util.LinkedList;

public class Process extends AnyProcess {
    private int indexInScheduler;
    private String name;    
    private LinkedList<Burst> chunksProcess;
    private int currentBurstIndex;
    private int totalRequiredTime;
    
    public Process(String n, LinkedList<Process> c) {
        this.name = n;
        this.chunksProcess = c; 
        this.status = ProcessStatus.READY;
        for (Burst b : this.chunksProcess) {
            this.totalRequiredTime += b.getRequiredTime();
        }         
    }
    
    private void workInProcess(int time) {                
        while (time > 0) {
            Burst b = this.chunksProcess.get(this.currentBurstIndex);
            int timeToWork = (time > b.requiredTime()) ? b.requiredTime() : time;                                    
            if (b.reduceTime(timeToWork) == 0) {
                this.currentBurstIndex++;
            }
            time -= timeToWork;
        }
    }
    
    public Burst getNextBurst() {
        return chunksProcess.get(currentBurstIndex);
    }
    
    public int getNextBurstTime() {
        return chunksProcess.get(currentBurstIndex).requiredTime();
    }
    
    private LinkedList<Burst> getBursts() {
        return this.chunksProcess;
    }
            
}