package edu.galileo.baquiax.process;

public class Burst {
    public static enum BurstType {
        CPU, IO;
    }     
    private BurstType type;
    private int requiredTime;
    private int timeWorked;     
    
    public Process(BurstType t, int time) {
        this.type = t;
        this.requiredTime = time;
    }
    
    public BurstType getType() {
        return this.type;
    }
    
    public int getRequiredTime() {
        return this.requiredTime;
    }
    
    public int getReminderTime() {
        return this.requiredTime - this.timeWorked;
    }
    
    public int reduceTime(int timeWorked) {         
        this.timeWorked += timeWorked;
        return (this.requiredTime - this.timeWorked);
    }
}