#include<stdio.h>

void fcfs_sort(int n,int processes[n],int arrival_time[n],int burst_time[n]){
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(arrival_time[i]>arrival_time[j]){
                int temp=arrival_time[i];
                arrival_time[i]=arrival_time[j];
                arrival_time[j]=temp;

                temp=processes[i];
                processes[i]=processes[j];
                processes[j]=temp;

                temp=burst_time[i];
                burst_time[i]=burst_time[j];
                burst_time[j]=temp;
            }
        }
    }
}

int main(){
    int n;
    printf("Enter the number of processes:");
    scanf("%d",&n);

    int processes[n],arrival_time[n],burst_time[n],turnaround_time[n],waiting_time[n];
    for(int i=0;i<n;i++){
        printf("Enter the arrival time of process %d:",(i+1));
        scanf("%d",&arrival_time[i]);
        printf("Enter the burst time of process %d:",(i+1));
        scanf("%d",&burst_time[i]);
        processes[i]=i+1;
    }

    fcfs_sort(n,processes,arrival_time,burst_time);

    int clock_cycle=0;

    for(int i=0;i<n;i++){
        if(clock_cycle<arrival_time[i]){
            clock_cycle=arrival_time[i];
        }

        clock_cycle+= burst_time[i];

        turnaround_time[i]=clock_cycle-arrival_time[i];

        waiting_time[i]=turnaround_time[i]-burst_time[i];
        
    }

    printf("\nProcess\tArrival Time\tBurst Time\tWaiting Time\tTurnaround Time\n");
    for(int i = 0; i < n; i++) {
        printf("P%d\t%d\t\t%d\t\t%d\t\t%d\n", processes[i], arrival_time[i], burst_time[i], waiting_time[i], turnaround_time[i]);
    }

    float total_waiting_time = 0, total_turnaround_time = 0;
    for(int i = 0; i < n; i++) {
        total_waiting_time += waiting_time[i];
        total_turnaround_time += turnaround_time[i];
    }
    
    printf("\nAverage Waiting Time: %.2f\n", total_waiting_time / n);
    printf("Average Turnaround Time: %.2f\n", total_turnaround_time / n);

    return 0;    
}