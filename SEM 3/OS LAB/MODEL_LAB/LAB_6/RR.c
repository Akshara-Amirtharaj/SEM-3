#include <stdio.h>

typedef struct {
    int process_id;
    int arrival_time;
    int burst_time;
    int remaining_time;
    int waiting_time;
    int turnaround_time;
    int completion_time;
    int response_time;
} Process;

int main() {
    int n, time_quantum;
    printf("Enter the number of processes: ");
    scanf("%d", &n);

    Process processes[n];

    for (int i = 0; i < n; i++) {
        processes[i].process_id = i + 1;
        printf("Enter arrival time of process %d: ", i + 1);
        scanf("%d", &processes[i].arrival_time);
        printf("Enter burst time of process %d: ", i + 1);
        scanf("%d", &processes[i].burst_time);
        processes[i].remaining_time = processes[i].burst_time;
    }

    printf("Enter the time quantum: ");
    scanf("%d", &time_quantum);

    int clock_cycle=0,completed=0;
    float total_waiting_time=0,total_response_time=0,total_turnaround_time=0;

    while(completed!=n){
        int idle=1;

        for(int i=0;i<n;i++){
            if(processes[i].remaining_time>0&&processes[i].arrival_time<=clock_cycle){
                idle=0;
                printf("|P%d (%d-",processes[i].process_id,clock_cycle);
                if(processes[i].remaining_time==processes[i].burst_time){
                    processes[i].response_time=clock_cycle-processes[i].arrival_time;
                    total_response_time+=processes[i].response_time;
                }

                if(processes[i].remaining_time>time_quantum){
                    processes[i].remaining_time-=time_quantum;
                    clock_cycle+=time_quantum;
                }
                else{
                    clock_cycle+=processes[i].remaining_time;
                    processes[i].remaining_time=0;
                    processes[i].turnaround_time=clock_cycle-processes[i].arrival_time;
                    processes[i].waiting_time=processes[i].turnaround_time-processes[i].burst_time;
                    completed++;
                    total_turnaround_time+=processes[i].turnaround_time;
                    total_waiting_time+=processes[i].waiting_time;
                    
                }
                printf("%d)|",clock_cycle);
            }

        }
            if(idle){
                clock_cycle++;
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
    printf("Average Turnaround Time: %.2f\n", total_turnaround_time / n);
    printf("Average Response Time: %.2f\n", total_response_time / n);
}        
