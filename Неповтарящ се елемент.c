#include <stdio.h>

int findFirstNonRepeated(int arr[], int n) {
    int i, j;
    int found;
    
    for (i = 0; i < n; i++) {
        found = 0;
        for (j = 0; j < n; j++) {
            if (i != j && arr[i] == arr[j]) {
                found = 1;
                break;
            }
        }
        if (!found) {
            return arr[i];
        }
    }
    
    return -1; // Ако е открит неповтарящ се елемент

int main() {
    int arr[] = {7 , 55, 55 , 66, 66};
    int n = sizeof(arr) / sizeof(arr[0]);
    int result = findFirstNonRepeated(arr, n);
    
    if (result != -1) {
        printf("%d\n", result);
    } else {
        printf("Няма неповтарящ се елемент\n");
    }
    
    return 0;
}