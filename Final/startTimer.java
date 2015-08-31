import java.util.*;
public class startTimer{
   private Process[] waitingQueue = new Process[10];
   private int timer;
   private Process[] processes;
   private int runningProcess = 0;

   public void startTimer(int timer, Process[] processes){
      this.timer = timer;
      this.processes = processes;
   }
   public void waitingQueue(Process process){
      Process temp;
      for(int i = 0; i < this.processes.length; i++){
         if((waitingQueue[i].getRunTime() > process.getRunTime()) || (waitingQueue[i] == null)){
            temp = waitingQueue[i];
            waitingQueue[i] = process;
            if(temp == null){
               return;
            }
            else{
               waitingQueue(temp);
            }
         } 
      }
   }
   public void FIFO(){
      for(int timer = 0; timer >= 0; timer++){
         for(int i = 0; i < this.processes.length; i++){
            if((timer == this.processes[i].getStartTime()) && (runningProcess == 0)){
               runningProcess = 1;
               System.out.println("Running process " + this.processes[i].getProcessNumber() + " at time " + timer);
            }
            else if(runningProcess == 1){
               waitingQueue(processes[i]);
               System.out.println("Process running: process " + this.processes[i].getProcessNumber() + " is waiting");
               this.processes[i].addWaitTime();
            }
            else if((waitingQueue[0] == null) && (runningProcess == 0)){
               
               System.out.println("No processes to run at time " + timer);
            }
            else{
               
            }
            if(timer == (this.processes[i].getStartTime() + this.processes[i].getRunTime())){
               System.out.println("Process " + this.processes[i].getProcessNumber() + " finished");
               runningProcess = 0;
            }
         }

      }
   }
      
   public void SJF(){
      for(int timer = 0; timer >= 0; timer++){
         for(int i = 0; i < this.processes.length; i++){
            
         }
      }
   }
      
   public void Pre_priority(){
      for(int timer = 0; timer >= 0; timer++){
         
      }
   }
      
   public void nonPre_priority(){
      for(int timer = 0; timer >= 0; timer++){
         
      }
   }
      
   public void RRS(){
      for(int timer = 0; timer >= 0; timer++){
         
      }
   }
}
