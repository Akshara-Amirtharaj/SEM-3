#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main() {
    // Fork a child process
    pid_t pid = fork();

    if (pid < 0) {
        // Error occurred while forking
        perror("Fork failed");
        exit(1);
    }
    else if (pid == 0) {
        // Child process
        printf("Child process (PID: %d) is terminating.\n", getpid());
        exit(0); // Child process terminates
    }
    else {
        // Parent process
        printf("Parent process (PID: %d) is sleeping.\n", getpid());
        sleep(10);  // Parent sleeps for 10 seconds, allowing child to become a Zombie
        // Parent collects child's exit status
        int status;
        pid_t child_pid = wait(&status);
        printf("Parent process collected child's (PID: %d) exit status.\n", child_pid);
    }

    return 0;
}
