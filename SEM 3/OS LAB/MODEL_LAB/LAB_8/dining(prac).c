#include<stdio.h>
#include<unistd.h>
#include<pthread.h>
#include<semaphore.h>

#define NUM_PHILOSOPHERS 5
sem_t chopsticks[NUM_PHILOSOPHERS];

void * dining(void *num){
    int id= *(int*) num;

    while(1){
        printf("Philosopher %d is thinking\n",id);
        sleep(1);

        if(id%2==0){
            sem_wait(&chopsticks[(id+1)%NUM_PHILOSOPHERS]);
            sem_wait(&chopsticks[(id)%NUM_PHILOSOPHERS]);
        }
        else{
            sem_wait(&chopsticks[(id)%NUM_PHILOSOPHERS]);
            sem_wait(&chopsticks[(id+1)%NUM_PHILOSOPHERS]);
        }

        printf("Philosopher %d is eating\n",id);
        sleep(2);
            sem_post(&chopsticks[(id)%NUM_PHILOSOPHERS]);
            sem_post(&chopsticks[(id+1)%NUM_PHILOSOPHERS]);

    }
}

int main(){

    pthread_t philosopher[NUM_PHILOSOPHERS];
    int ids[NUM_PHILOSOPHERS];

    for(int i=0;i<NUM_PHILOSOPHERS;i++){
        sem_init(&chopsticks[i],0,1);
    }
    for(int i=0;i<NUM_PHILOSOPHERS;i++){
        ids[i]=(i+1);
        pthread_create(&philosopher[i],NULL,dining,&ids[i]);
    }

    for(int i=0;i<NUM_PHILOSOPHERS;i++){
        pthread_join(philosopher[i],NULL);
    }

    for(int i=0;i<NUM_PHILOSOPHERS;i++){
        sem_destroy(&chopsticks[i]);
    }
    
}