#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t pid = fork();

    if (pid > 0) {
        // Parent process
        printf("Parent process, PID: %d\n", getpid());
        printf("Child process PID: %d\n", pid);
        exit(0);  // Parent exits immediately
    } 
    else if (pid == 0) {
        // Child process
        sleep(2);  // Wait for parent to exit
        printf("Orphan child process, PID: %d, new parent PID: %d\n", getpid(), getppid());
        sleep(10);  // Keep the child process alive for observation
    } 
    else {
        perror("Fork failed");
        return 1;
    }

    return 0;
}
