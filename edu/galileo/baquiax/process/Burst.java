package edu.galileo.baquiax.process;

public class Burst {
    public static enum BurstType {
        CPU, IO;
    }     
    private BurstType type;
    private int time;
    private int timeWorked;     
    
    public Process(BurstType t, int time) {
        this.type = t;
        this.time = time;
    }
    
    public BurstType getType() {
        return this.type;
    }
    
    public int getTime() {
        return this.time;
    }
    
    public int reduceTime(int timeWorked) {         
        this.timeWorked += timeWorked;
        return (this.time - this.timeWorked);
    }
}