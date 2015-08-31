//CS 201 Final project
//CPU schedular simulation
//Designed by Hunter Brochu

import java.util.*;
import java.io.*;

public class Simulation{
   private static Random random = new Random();
   private static int rando = random.nextInt(10);
   private static Process[] processes = new Process[rando];
   private static Process[] waitingQueue = new Process[rando];
   private static int timer;
   private static int runningProcess = 0;
   private static Process currentProcess;


   
   public static void construct_processes(){

      for(int i = 0; i < rando; i++){
         processes[i] = new Process(i, random.nextInt(10), random.nextInt(10), random.nextInt(10));
         System.out.print(processes[i].getProcessNumber() + " " +  processes[i].getStartTime() + " " + processes[i].getRunTime() + "\n");
      }
   }
   
   public static void sendToQueue(Process process){
      Process temp;
      for(int i = 0; i < waitingQueue.length; i++){
         if((waitingQueue[i] == null) || (waitingQueue[i].getRunTime() > process.getRunTime())){
            temp = waitingQueue[i];
            waitingQueue[i] = process;
            if(temp == null){
               return;
            }
            else{
               sendToQueue(temp);
            }
         } 
      }
   }
   public static Process sendToQueue(){
   Process temp = waitingQueue[0];
      for(int i = 1; (i-1) < waitingQueue.length; i++){
         waitingQueue[i-1] = waitingQueue[i];
      }
      return temp;
   }
   public static void addWaitingTime(){
      for(int i = 0; i <  waitingQueue.length; i++){
         if(waitingQueue[i] != null){
            waitingQueue[i].addWaitTime();
         }
      }
   }
   public static void FIFO(){
      for(int timer = 0; timer >= 0; timer++){
         for(int i = 0; i < processes.length; i++){
            if(waitingQueue[0] == null && (i+1) == processes.length && processes == null){
               System.out.println("Out of processes, end of simulation.");
               return;
            }
            if((waitingQueue[0] == null) && (i+1) == processes.length && (runningProcess == 0) && i == processes.length){
               
               System.out.println("No processes to run at time " + timer);
            }
            if((timer == processes[i].getStartTime()) && (i+1) == processes.length && (runningProcess == 0)){
               runningProcess = 1;
               currentProcess = processes[i];
               
               System.out.println("Running process " + currentProcess.getProcessNumber() + " at time " + timer);
            }
            if(timer == processes[i].getStartTime() && (i+1) == processes.length && runningProcess == 1){
               sendToQueue(processes[i]);
               System.out.println("Process running: process " + waitingQueue[0].getProcessNumber() + " is waiting at time " + timer);
               addWaitingTime();
            }
            

            if(currentProcess != null && (i+1) == processes.length && timer == (currentProcess.getStartTime() + currentProcess.getRunTime())){
               System.out.println("Process " + currentProcess.getProcessNumber() + " finished");
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

   public static void main(String [] args){
      construct_processes();
      FIFO();
      
      
     
   }
}




