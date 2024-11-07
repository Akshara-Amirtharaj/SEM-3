#include <stdio.h>
#include <stdbool.h>

#define MAX_PROCESSES 5
#define MAX_RESOURCES 3

int allocation[MAX_PROCESSES][MAX_RESOURCES];
int max[MAX_PROCESSES][MAX_RESOURCES];
int need[MAX_PROCESSES][MAX_RESOURCES];
int available[MAX_RESOURCES];

// Function to calculate the need matrix
void calculateneed(int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            need[i][j] = max[i][j] - allocation[i][j];
        }
    }
}


bool isdeadlock(int n, int m) {
    bool finish[MAX_PROCESSES] = { false };  // Tracks if each process can finish
    int work[MAX_RESOURCES];                 // Work array to track available resources

    // Initialize work with available resources
    for (int i = 0; i < m; i++) {
        work[i] = available[i];
    }

    // Main loop to check if processes can finish
    while (true) {
        bool found = false;

        // Try to find an unfinished process that can finish
        for (int i = 0; i < n; i++) {
            if (!finish[i]) {  // Process is not yet finished
                bool canfinish = true;

                // Check if this process can finish with current work resources
                for (int j = 0; j < m; j++) {
                    if (need[i][j] > work[j]) {
                        canfinish = false;
                        break;
                    }
                }

                // If process can finish, mark it as finished and update work
                if (canfinish) {
                    for (int j = 0; j < m; j++) {
                        work[j] += allocation[i][j];
                    }
                    finish[i] = true;
                    found = true;
                }
            }
        }

        // If no process could finish in this pass, break the loop
        if (!found) break;
    }

    // Check for any unfinished processes indicating deadlock
    bool deadlock = false;
    for (int i = 0; i < n; i++) {
        if (!finish[i]) {
            deadlock = true;
            printf("Process %d is in deadlock\n", i + 1);
        }
    }
    return deadlock;
}

int main() {
    int n, m;
    printf("Enter the number of processes and resources: ");
    scanf("%d %d", &n, &m);

    // Input allocation matrix
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("Enter the Resource %d allocated for Process %d: ", j + 1, i + 1);
            scanf("%d", &allocation[i][j]);
        }
    }

    // Input max matrix
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("Enter the maximum Resource %d for Process %d: ", j + 1, i + 1);
            scanf("%d", &max[i][j]);
        }
    }  

    // Input available resources
    for (int i = 0; i < m; i++) {
        printf("Enter the Available resource %d: ", i + 1);
        scanf("%d", &available[i]);
    }

    // Calculate the need matrix
    calculateneed(n, m);

    // Check for deadlock
    if (isdeadlock(n, m)) {
        printf("Deadlock is detected.\n");
    } else {
        printf("No deadlock detected.\n");
    }

    return 0;
}
