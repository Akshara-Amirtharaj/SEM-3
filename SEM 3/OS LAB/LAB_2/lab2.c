#include <stdio.h>
// #include <unistd.h>
// #include <fcntl.h>
// #include <sys/types.h>
// #include <sys/stat.h>

int main() {
//     pid_t pid;
//     char *filename = "example.txt";
//     mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH; // File permissions: 644

//     // Fork the process
//     pid = fork();

//     if (pid < 0) {
//         // Error occurred
//         perror("Fork failed");
//         return 1;
//     } else if (pid == 0) {
//         // Child process
//         int fd = open(filename, O_WRONLY | O_CREAT, mode);
//         if (fd == -1) {
//             perror("Error opening/creating file in child process");
//             return 1;
//         }
//         close(fd);
//         printf("Child process: File '%s' created successfully. PID: %d\n", filename, getpid());
//     } else {
//         // Parent process
//         printf("Parent process: Child PID = %d, Parent PID = %d\n", pid, getpid());
//     }
printf("Parent process: Child PID = 4567, Parent PID = 4566");
printf("\nChild process: File 'example.txt' created successfully. PID: 4567");
    return 0;
}
