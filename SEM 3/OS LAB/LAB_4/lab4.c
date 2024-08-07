#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

#define BUFFER_SIZE 1024

int main() {
    int pipe_fd[2];
    pid_t pid;
    char buffer[BUFFER_SIZE];
    
    // Create the pipe
    if (pipe(pipe_fd) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }
    
    // Fork the process
    pid = fork();
    
    if (pid == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }
    
    if (pid == 0) {  // Child process
        close(pipe_fd[1]); // Close unused write end of pipe
        
        
            // Read from the pipe
            ssize_t bytesRead = read(pipe_fd[0], buffer, BUFFER_SIZE - 1);
            if (bytesRead > 0) {
                buffer[bytesRead] = '\0'; // Null-terminate the string
                printf("Child received: %s", buffer);
                fflush(stdout); // Ensure output is printed immediately
            } else if (bytesRead == 0) {
                // End of input
        
            } else {
                perror("read");
                exit(EXIT_FAILURE);
            }
        
        
        close(pipe_fd[0]); // Close read end of pipe
        exit(EXIT_SUCCESS);
    } else {  // Parent process
        close(pipe_fd[0]); // Close unused read end of pipe
        
        
            printf("Enter text (or 'exit' to quit): ");
            fflush(stdout); // Ensure prompt is printed immediately
            
            if (fgets(buffer, BUFFER_SIZE, stdin) == NULL) {
                perror("fgets");
                exit(EXIT_FAILURE);
            }
            
            // Write to the pipe
            if (write(pipe_fd[1], buffer, strlen(buffer)) == -1) {
                perror("write");
                exit(EXIT_FAILURE);
            }
            
            // Exit condition
            if (strncmp(buffer, "exit", 4) == 0) {
                
            }
        
        
        close(pipe_fd[1]); // Close write end of pipe
        // Wait for the child process to finish
        wait(NULL);
        exit(EXIT_SUCCESS);
    }
}
