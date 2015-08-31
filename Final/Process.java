import java.util.*;
public class Process{
   private int number, start_time, run_time, priority;
   public Process(int number, int start_time, int run_time, int priority){
      this.number = number;
      this.start_time = start_time;
      this.run_time = run_time;
      this.priority = priority;
   }
   public int getRunTime(){
      return run_time;
   }
   public int getStartTime(){
      return start_time;
   }
   public int getProcessNumber(){
      return number;
   }
   public int getPriority(){
      return priority;
   }
   public void addWaitTime(){
      start_time = start_time + 1;
      
   }
}














