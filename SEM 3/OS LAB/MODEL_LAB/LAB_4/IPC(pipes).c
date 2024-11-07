#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <sched.h>
#include <sys/wait.h> 

int main() {
    int pipefd[2];               // Array to hold read and write ends of the pipe
    pid_t pid;                   // Process ID
    char write_msg[] = "Hello from parent process!";
    char read_msg[100];          // Buffer to hold the message read from the pipe

    // 1. Create the pipe
    if (pipe(pipefd) == -1) {
        perror("pipe");
        exit(1);
    }

    // 2. Fork the process
    pid = fork();

    if (pid < 0) {
        // Error in forking
        perror("fork");
        exit(1);
    } else if (pid > 0) {
        // Parent process
        close(pipefd[0]); // Close unused read end

        // Write message to the pipe
        write(pipefd[1], write_msg, strlen(write_msg) + 1);
        close(pipefd[1]); // Close write end after writing

        // Wait for child process to finish
        wait(NULL);
    } else {
        // Child process
        close(pipefd[1]); // Close unused write end

        // Read message from the pipe
        read(pipefd[0], read_msg, sizeof(read_msg));
        printf("Child process received: %s\n", read_msg);
        close(pipefd[0]); // Close read end after reading
    }

    return 0;
}
