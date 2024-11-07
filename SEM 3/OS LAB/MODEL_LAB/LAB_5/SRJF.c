#include<stdio.h>
#include<stdbool.h>

typedef struct{
    int arrival_time;
    int burst_time;
    int response_time;
    int waiting_time;
    int turnaround_time;
    int process_id;
    int remaining_time;
    int completion_time;
    bool iscompleted;
}Process;

int main(){
    int n,i;
    printf("Enter the number of processes:");
    scanf("%d",&n);

    Process processes[n];

    for (i=0;i<n;i++){

        printf("Enter the arrival time of process %d:",(i+1));
        scanf("%d",&processes[i].arrival_time);
        printf("Enter the burst time of process %d:",(i+1));
        scanf("%d",&processes[i].burst_time);
        processes[i].process_id=i+1;
        processes[i].iscompleted=false;
        processes[i].remaining_time=processes[i].burst_time;        
    }

    int clock_cycle=0,completed=0;
    float total_waiting_time=0;
    float total_turn_around_time=0;
    float total_response_time=0;


    while(completed!=n){
        int shortest=-1;
        int min_remaining_time=__INT_MAX__;
        for(int i=0;i<n;i++){
            if(processes[i].arrival_time<=clock_cycle && processes[i].remaining_time<min_remaining_time&&!processes[i].iscompleted){
                min_remaining_time=processes[i].remaining_time;
                shortest=i;
            }
        }

            if(shortest==-1){
                clock_cycle++;
                continue;
            }

            if(processes[shortest].remaining_time==processes[shortest].burst_time){
                processes[shortest].response_time=clock_cycle-processes[shortest].arrival_time;
                total_response_time+=processes[shortest].response_time;
            }

            printf("P%d (%d)",processes[shortest].process_id,clock_cycle);
            processes[shortest].remaining_time--;
            clock_cycle++;

            if(processes[shortest].remaining_time==0){
                processes[shortest].iscompleted=true;
                processes[shortest].completion_time=clock_cycle;
                processes[shortest].turnaround_time=processes[shortest].completion_time-processes[shortest].arrival_time;
                processes[shortest].waiting_time=processes[shortest].turnaround_time-processes[shortest].burst_time;

                total_turn_around_time+=processes[shortest].turnaround_time;
                total_waiting_time+=processes[shortest].waiting_time;
                completed++;
            }
        

    }
    printf("\n");
    printf("\nProcess\tArrival\tBurst\tWaiting\tTurnaround\tResponse\n");
    for (int i = 0; i < n; i++) {
        printf("P%d\t%d\t%d\t%d\t%d\t\t%d\n", processes[i].process_id,
               processes[i].arrival_time,
               processes[i].burst_time,
               processes[i].waiting_time,
               processes[i].turnaround_time,
               processes[i].response_time);
    }

    // Display averages
    printf("\nAverage Waiting Time: %.2f\n", total_waiting_time / n);
    printf("Average Turnaround Time: %.2f\n", total_turn_around_time / n);
    printf("Average Response Time: %.2f\n", total_response_time / n);
}    
       
