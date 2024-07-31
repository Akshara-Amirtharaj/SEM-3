#include <stdio.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdlib.h>

int main()
{
    // ftok to generate unique key, same as used by the writer program
    key_t key = ftok("shmfile", 65);

    // shmget returns an identifier in shmid, same as the writer program
    int shmid = shmget(key, 1024, 0666 | IPC_CREAT);

    // shmat to attach to shared memory
    char *str = (char*) shmat(shmid, (void*)0, 0);

    printf("Data read from memory: %s\n", str);

    // detach from shared memory
    shmdt(str);

    // destroy the shared memory
    shmctl(shmid, IPC_RMID, NULL);

    return 0;
}
