#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>

#define SHM_SIZE 1024  // Size of shared memory (1 KB)

int main() {
    // 1. Create a unique key for the shared memory
    key_t key = ftok("shmfile", 65); // Generates a unique key based on file and number
    if (key == -1) {
        perror("ftok");
        exit(1);
    }

    // 2. Create a shared memory segment
    int shmid = shmget(key, SHM_SIZE, 0666 | IPC_CREAT);
    if (shmid == -1) {
        perror("shmget");
        exit(1);
    }

    // 3. Attach to the shared memory and get a pointer to it
    char *data = (char *)shmat(shmid, NULL, 0);
    if (data == (char *)(-1)) {
        perror("shmat");
        exit(1);
    }

    // 4. Write data to the shared memory
    printf("Enter some text to write to shared memory: ");
    fgets(data, SHM_SIZE, stdin); // Reads input and stores it in shared memory

    printf("Data written to shared memory: %s\n", data);

    // 5. Detach from the shared memory
    shmdt(data);

    // 6. Attach again to read the data (simulating another process reading it)
    data = (char *)shmat(shmid, NULL, 0);
    if (data == (char *)(-1)) {
        perror("shmat");
        exit(1);
    }

    // 7. Read data from the shared memory
    printf("Data read from shared memory: %s\n", data);

    // 8. Detach from shared memory and mark it for deletion
    shmdt(data);
    shmctl(shmid, IPC_RMID, NULL);

    return 0;
}
