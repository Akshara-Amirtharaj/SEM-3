#include<stdio.h>
#include<stdbool.h>

#define MAX_PROCESSES 5
#define MAX_RESOURCES 5

int allocation[MAX_PROCESSES][MAX_RESOURCES];
int max[MAX_PROCESSES][MAX_RESOURCES];
int need[MAX_PROCESSES][MAX_RESOURCES];
int available[MAX_RESOURCES];

void calculateneed(int n,int m){
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            need[i][j]=max[i][j]-allocation[i][j];
        }
    }
}

bool is_safe(int n,int m){
    bool isfinish[MAX_PROCESSES]={false};
    int work[MAX_RESOURCES];

    for(int i=0;i<m;i++){
        work[i]=available[i];
    }

    while(true){
        bool found=false;

        for(int i=0;i<n;i++){
            
            if(!isfinish[i]){
                bool canfinish=true;
                for(int j=0;j<m;j++){
                    if(need[i][j]>work[j]){
                        canfinish=false;
                        break;
                    }
                }
                if(canfinish){
                    for(int j=0;j<m;j++){
                        work[j]+=allocation[i][j];
                    }
                    found=true;
                    isfinish[i]=true;
                }
            }      
        }

        if(!found){
            break;
        }
    }

    for(int i=0;i<n;i++){
        if(!isfinish[i]){
            return false;
        }
    }
    return true;
}

bool request_resource(int process,int resource[MAX_RESOURCES],int n,int m){
    for(int i=0;i<m;i++){
        if(resource[i]>need[process][i]){
            printf("Process has exceeded the maximum claim");
            return false;
        }
        if(resource[i]>available[i]){
            printf("Not enough resources");
            return false;
        }
    }

    for(int i=0;i<m;i++){
        allocation[process][i]+=resource[i];
        available[i]-=resource[i];
        need[process][i]-=resource[i];
    }
        if(is_safe(n,m)){
            printf("Resource is allocated successfully");
            return true;
        }
        else{
            for(int i=0;i<m;i++){
            allocation[process][i]-=resource[i];
            available[i]+=resource[i];
            need[process][i]+=resource[i];
            printf("Deadlock is detected and not safe");
            }

        }
    
}


int main() {
    int n, m;
    printf("Enter the number of processes and resources: ");
    scanf("%d %d", &n, &m);

    // Input allocation matrix
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("Enter the Resource %d allocated for Process %d: ", j + 1, i + 1);
            scanf("%d", &allocation[i][j]);
        }
    }

    // Input max matrix
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("Enter the maximum Resource %d for Process %d: ", j + 1, i + 1);
            scanf("%d", &max[i][j]);
        }
    }  

    // Input available resources
    for (int i = 0; i < m; i++) {
        printf("Enter the Available resource %d: ", i + 1);
        scanf("%d", &available[i]);
    }

    // Calculate the need matrix
    calculateneed(n, m);
    int process;
    int request[MAX_RESOURCES];

    printf("Enter process number making the request: ");
    scanf("%d", &process);

    printf("Enter request vector:\n");
    for (int i = 0; i < m; i++)
        scanf("%d", &request[i]);

    if (request_resource(process, request, n, m))
        printf("Resources allocated.\n");
    else
        printf("Resources not allocated.\n");

    return 0;

    return 0;
}