#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
    // Fork a child process
    pid_t pid = fork();

    if (pid < 0) {
        // Error occurred while forking
        perror("Fork failed");
        exit(1);
    }
    else if (pid > 0) {
        // Parent process
        printf("Parent process (PID: %d) is terminating.\n", getpid());
        exit(0);  // Parent process terminates immediately
    }
    else {
        // Child process
        sleep(5);  // Child process runs after parent has terminated
        printf("Child process (PID: %d) is still running, adopted by init.\n", getpid());
        // Print the parent PID to demonstrate that it is now 1 (init/systemd)
        printf("Child process's parent PID is now: %d\n", getppid());
    }

    return 0;
}
