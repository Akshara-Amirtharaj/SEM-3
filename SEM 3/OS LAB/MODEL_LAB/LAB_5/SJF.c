#include<stdio.h>
#include<stdbool.h>

typedef struct{
    int process_id;
    int arrival_time;
    int completion_time;
    int turnaround_time;
    int waiting_time;
    int burst_time;
    bool is_completed;
}Process;

int main(){
    int n,i;
    printf("Enter the number of processes:");
    scanf("%d",&n);

    Process processes[n];

    for (i=0;i<n;i++){
        processes[i].process_id=i+1;
        processes[i].is_completed=false;
        printf("Enter the arrival time of process %d:",(i+1));
        scanf("%d",&processes[i].arrival_time);
        printf("Enter the burst time of process %d:",(i+1));
        scanf("%d",&processes[i].burst_time);
    }
    
    int clock_cycle=0,completed=0;

    while(completed!=n){
        int shortest=-1;
        int min_burst_time=__INT_MAX__;
        for(int i=0;i<n;i++){
            if(processes[i].arrival_time<=clock_cycle && !processes[i].is_completed &&  processes[i].burst_time<min_burst_time){
                min_burst_time=processes[i].burst_time;
                shortest=i;
            }
        }

        if(shortest==-1){
            clock_cycle++;
            continue;
        }

        processes[shortest].completion_time=clock_cycle+processes[shortest].burst_time;
        processes[shortest].turnaround_time=processes[shortest].completion_time-processes[shortest].arrival_time;
        processes[shortest].waiting_time=processes[shortest].turnaround_time-processes[shortest].burst_time;
        processes[shortest].is_completed=true;

        printf("P%d |%d-%d|",processes[shortest].process_id,clock_cycle,(clock_cycle+processes[shortest].burst_time));
        clock_cycle+=processes[shortest].burst_time;
        completed++;
    }
    
    printf("\nProcess\tArrival\tBurst\tWaiting\tTurnaround\n");
    for (int i = 0; i < n; i++) {
        printf("P%d\t%d\t%d\t%d\t%d\n", processes[i].process_id,
               processes[i].arrival_time,
               processes[i].burst_time,
               processes[i].waiting_time,
               processes[i].turnaround_time);
    }


}    
