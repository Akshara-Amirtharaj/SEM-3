#include <stdio.h>
#include <stdbool.h>
#include <limits.h>

typedef struct {
    int process_id;
    int arrival_time;
    int burst_time;
    int remaining_time;
    int waiting_time;
    int turnaround_time;
    int response_time;
    int priority;
    bool is_completed;
} Process;


   int main() {
    int n;
    printf("Enter the number of processes: ");
    scanf("%d", &n);

    Process processes[n];

    for (int i = 0; i < n; i++) {
        processes[i].process_id = i + 1;
        printf("Enter arrival time of process %d: ", i + 1);
        scanf("%d", &processes[i].arrival_time);
        printf("Enter burst time of process %d: ", i + 1);
        scanf("%d", &processes[i].burst_time);
        printf("Enter priority of process %d (higher) number = higher priority): ", i + 1);
        scanf("%d", &processes[i].priority);
        
        processes[i].remaining_time = processes[i].burst_time;
        processes[i].is_completed = false;
    }
    

    int clock_cycle = 0, completed = 0;
    float total_waiting_time = 0, total_turnaround_time = 0,total_response_time=0;

    printf("\nGantt Chart:\n"); 

    while(completed!=n){
        int highest_priority_process=-1;
        int higher_priorty=INT_MIN;
        for(int i=0;i<n;i++){
            if(!processes[i].is_completed && processes[i].arrival_time<=clock_cycle && processes[i].priority>higher_priorty){
                higher_priorty=processes[i].priority;
                highest_priority_process=i;
            }
        }
        if(highest_priority_process==-1){
            clock_cycle++;
            continue;
        }

        if(processes[highest_priority_process].remaining_time==processes[highest_priority_process].burst_time){
            processes[highest_priority_process].response_time=clock_cycle;
            total_response_time+=processes[highest_priority_process].response_time;
        }
        printf("|P%d (%d)|",processes[highest_priority_process].process_id,clock_cycle);
        processes[highest_priority_process].remaining_time--;
        clock_cycle++;

        if(processes[highest_priority_process].remaining_time==0){
            processes[highest_priority_process].is_completed=true;
            processes[highest_priority_process].turnaround_time=clock_cycle-processes[highest_priority_process].arrival_time;
            processes[highest_priority_process].waiting_time=processes[highest_priority_process].turnaround_time-processes[highest_priority_process].burst_time;
            total_turnaround_time+=processes[highest_priority_process].turnaround_time;
            total_waiting_time+=processes[highest_priority_process].waiting_time;
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
    printf("Average Turnaround Time: %.2f\n", total_turnaround_time / n);
    printf("Average Response Time: %.2f\n", total_response_time / n);    
}
