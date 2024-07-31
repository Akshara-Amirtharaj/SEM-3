#include<stdio.h>
#include<sys/shm.h>
#include<sys/ipc.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    key_t key=ftok("shmfile",65);
    int shmid=shmget(key ,1024,0666 | IPC_CREAT);

    char* str =(char*)shmat(shmid,(void*)0,0);
    
    printf("Write data:");
    fgets(str,1024,stdin);
    printf("Data written in memory:%s\n",str);
    return 0 ;
}