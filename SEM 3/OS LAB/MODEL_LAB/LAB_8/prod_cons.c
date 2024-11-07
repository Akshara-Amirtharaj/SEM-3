#include<stdio.h>
#include<pthread.h>
#include<semaphore.h>
#include<unistd.h>
#define BUFFER_SIZE 2

int in=0, out=0;
sem_t empty;
sem_t full;

int buffer[BUFFER_SIZE];

pthread_mutex_t mutex;

void* producer(void* arg) {
    int item;
    for (int i = 0; i < 5; i++) {
        item = i + 1;
        sem_wait(&empty);
        pthread_mutex_lock(&mutex);

        printf("Producer produced: %d\n", item);
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;

        pthread_mutex_unlock(&mutex);
        sem_post(&full);
        sleep(2);
    }
    return NULL;
}

void* consumer(void* arg) {
    for (int i = 0; i < 5; i++) {
        sem_wait(&full);
        pthread_mutex_lock(&mutex);

        int item = buffer[out];
        printf("Consumer consumed: %d\n", item);
        out = (out + 1) % BUFFER_SIZE;

        pthread_mutex_unlock(&mutex);
        sem_post(&empty);
        sleep(1); 
    }
    return NULL;
}

int main() {
    pthread_t producer_thread, consumer_thread;

    sem_init(&empty, 0, BUFFER_SIZE);
    sem_init(&full, 0, 0);
    pthread_mutex_init(&mutex, NULL);

    pthread_create(&producer_thread, NULL, producer, NULL);
    pthread_create(&consumer_thread, NULL, consumer, NULL);

    pthread_join(producer_thread, NULL);
    pthread_join(consumer_thread, NULL);

    pthread_mutex_destroy(&mutex);
    sem_destroy(&empty);
    sem_destroy(&full);

    return 0;
}
