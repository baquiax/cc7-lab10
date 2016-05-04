package edu.galileo.baquiax.process;
import java.util.LinkedList;

public class Process extends AnyProcess {            
    private String name;    
    private LinkedList<Burst> chunksProcess;
    private int currentIndex;
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
            Burst b = this.chunksProcess.get(this.currentIndex);
            int timeToWork = (time > b.requiredTime()) ? b.requiredTime() : time;                        
            if (b.reduceTime(timeToWork) == 0) {
                this.currentIndex++;
            }
            time -= timeToWork;
        }
    }
    
    private LinkedList<Burst> getBursts() {
        return this.chunksProcess;
    }
            
}