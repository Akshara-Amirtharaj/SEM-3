#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t pid = fork();

    if (pid > 0) {
        // Parent process
        printf("Parent process, PID: %d\n", getpid());
        printf("Child PID: %d is now a zombie for 10 seconds\n", pid);
        sleep(10);  // Sleep for 10 seconds to keep the child as a zombie
        // Parent should call wait() here, but we're skipping it to show the zombie state
    } else if (pid == 0) {
        // Child process
        printf("Child process, PID: %d\n", getpid());
        exit(0);  // Child process exits immediately
    } else {
        perror("Fork failed");
        return 1;
    }

    return 0;
}
