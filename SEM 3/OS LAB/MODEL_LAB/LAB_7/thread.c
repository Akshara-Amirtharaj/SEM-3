#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void* print_message(void* arg) {
    char* message = (char*)arg;
    printf("%s\n", message);
    return NULL;
}

int main() {
    pthread_t thread1, thread2;

    // Messages to be printed by each thread
    void* message1 = "Hello from Thread 1";
    void* message2 = "Hello from Thread 2";

    // Creating threads
    if (pthread_create(&thread1, NULL, print_message, message1) != 0) {
        perror("Failed to create thread 1");
        return 1;
    }

    if (pthread_create(&thread2, NULL, print_message, message2) != 0) {
        perror("Failed to create thread 2");
        return 1;
    }

    // Waiting for both threads to complete
    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    printf("Both threads have finished.\n");
    return 0;
}
