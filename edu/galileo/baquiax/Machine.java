package edu.galileo.baquiax;
import edu.galileo.baquiax.process.Process;
import java.util.HashMap;

public class Machine implements Runnable {
    public final static TICK_TIME = 500;
    public static CURRENT_TIME = 0;
    
    private HashMap<int, Process> allProcesses;
    private Scheduler scheduler;         
    public Machine (Scheduler s, HashMap<int, Process> all) {
        this.scheduler = s;
        this.allProcesses = all;
        Thread t = new Thread(this.scheduler);
        t.start();
    }
    
    @Override
    public void run() {
        //CPU Tick time = 500ms                
        while(true) {
            Process p = allProcesses.get(CURRENT_TIME);
            if ( p != null ) {
                this.scheduler.newProcess(p);             
            }            
            Thread.sleep(TICK_TIME);
            CURRENT_TIME++;    
        }        
    }    
}