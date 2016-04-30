package edu.galileo.baquiax.process;
import java.util.LinkedList;

public class Process {
    private String name;
    private LinkedList<Burst> chunksProcess;
    
    public Process(String n, LinkedList<Process> c) {
        this.name = n;
        this.chunksProcess = c;           
    }
    
    public void workInBurst(int time) {
        Burst b = this.chunksProcess.peek();
        if (b.reduceTime(time) == 0) {
            this.chunksProcess.pop();
        }
    }
    
    public LinkedList<Burst> getBursts() {
        return this.chunksProcess;
    }
}