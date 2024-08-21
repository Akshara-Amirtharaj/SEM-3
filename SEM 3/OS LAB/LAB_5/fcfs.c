// C program for implementation of FCFS  
// scheduling 
#include<stdio.h> 
// Function to find the waiting time for all  
// processes 
void findWaitingTime(int processes[], int n,  
                          int bt[], int wt[]) 
{ 
    // waiting time for first process is 0 
    wt[0] = 0; 
  
    // calculating waiting time 
    for (int  i = 1; i < n ; i++ ) 
        wt[i] =  bt[i-1] + wt[i-1] ; 
} 
  
// Function to calculate turn around time 
void findTurnAroundTime( int processes[], int n,  
                  int bt[], int wt[], int tat[]) 
{ 
    // calculating turnaround time by adding 
    // bt[i] + wt[i] 
    for (int  i = 0; i < n ; i++) 
        tat[i] = bt[i] + wt[i]; 
} 
  
//Function to calculate average time 
void findavgTime( int processes[], int n, int bt[]) 
{ 
    int wt[n], tat[n], total_wt = 0, total_tat = 0; 
  
    //Function to find waiting time of all processes 
    findWaitingTime(processes, n, bt, wt); 
  
    //Function to find turn around time for all processes 
    findTurnAroundTime(processes, n, bt, wt, tat); 
  
    //Display processes along with all details 
    printf("Processes   Burst time   Waiting time   Turn around time\n"); 
  
    // Calculate total waiting time and total turn  
    // around time 
    for (int  i=0; i<n; i++) 
    { 
        total_wt = total_wt + wt[i]; 
        total_tat = total_tat + tat[i]; 
        printf("   %d ",(i+1));
        printf("       %d ", bt[i] );
        printf("       %d",wt[i] );
        printf("       %d\n",tat[i] ); 
    } 
    float s=(float)total_wt / (float)n;
    float t=(float)total_tat / (float)n;
    printf("Average waiting time = %f",s);
    printf("\n");
    printf("Average turn around time = %f ",t); 
} 
  
// Driver code 
int main() 
{ 
    int no_of_processes=0;
    
    printf("Enter the number of processes:");
    scanf("%d",&no_of_processes);
    int processes[no_of_processes],burst_time[no_of_processes];
    for(int i=0;i<no_of_processes;i++){
        printf("Enter the process:");
        scanf("%d",&processes[i]);
        printf("Enter the burst time:");
        scanf("%d",&burst_time[i]);
    }
    
    no_of_processes = sizeof processes / sizeof processes[0]; 
  
    findavgTime(processes, no_of_processes,  burst_time); 
    return 0; 
} 
// This code is contributed by Shivi_Aggarwal

