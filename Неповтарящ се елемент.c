#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define MAX_SIZE 100

int arr[MAX_SIZE];
int n = 0;

int isValidInt(const char *str) {
    if (!str || !*str)
        return 0;
    while (*str) {
        if (!isdigit(*str))
            return 0;
        str++;
    }
    return 1;
}

void inputArray() {
    printf("Въведете колко елемнта е масива (до %d): ", MAX_SIZE);
    scanf("%d", &n);
    if (n < 0 || n > MAX_SIZE) {
        printf("Броя на елементите трябва да е от 0 до %d.\n", MAX_SIZE);
        return;
    }
    printf("Въведете %d цели числа разделени с разстояние: ", n);
    for (int i = 0; i < n; i++) {
        char input[100];
        scanf("%s", input);
        if (!isValidInt(input)) {
            printf("Грешка при входиране. Моля въведете Цели числа.\n");
            return;
        }
        arr[i] = atoi(input);
    }
}

void checkElement() {
    int element;
    printf("Въведете елемент за проверка: ");
    scanf("%d", &element);
    for (int i = 0; i < n; i++) {
        if (arr[i] == element) {
            printf("Елемента %d фигурира в масива.\n", element);
            return;
        }
    }
    printf("Елемента %d не фигурира в масива.\n", element);
}

void printArray() {
    if (n == 0) {
        printf("Не е зададен масив.\n");
        return;
    }
    printf("Елементи в Масива: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void loadFromFile() {
    char filename[100];
    printf("Въведете директория на файла: ");
    scanf("%s", filename);
    FILE *file = fopen(filename, "r");
    if (!file) {
        printf("Грешка при отваряне на файла\n");
        return;
    }
    int i = 0;
    while (fscanf(file, "%d", &arr[i]) != EOF && i < MAX_SIZE) {
        i++;
    }
    fclose(file);
    n = i;
    printf("Масива е успешно зареден от файл.\n");
}

void saveToFile() {
    if (n == 0) {
        printf("Няма зададен масив.\n");
        return;
    }
    char filename[100];
    printf("Въведете директория и име на файл за запаметяване: ");
    scanf("%s", filename);
    FILE *file = fopen(filename, "w");
    if (!file) {
        printf("Грешка при запаметяване. \n");
        return;
    }
    for (int i = 0; i < n; i++) {
        fprintf(file, "%d ", arr[i]);
    }
    fclose(file);
    printf("Масива е успешно записан.\n");
}

void findFirstNonRepeated() {
    if (n == 0) {
        printf("Няма зададен масив.\n");
        return;
    }
    int found;
    for (int i = 0; i < n; i++) {
        found = 0;
        for (int j = 0; j < n; j++) {
            if (i != j && arr[i] == arr[j]) {
                found = 1;
                break;
            }
        }
        if (!found) {
            printf("Първия неповтарящ се елемент е: %d\n", arr[i]);
            return;
        }
    }
    printf("Няма неповтарящи се елементи.\n");
}

int main() {
    int choice;
    while (1) {
        printf("\nМеню:\n");
        printf("1. Входиране на масив\n");
        printf("2. Проверка за елемент в масива\n");
        printf("3. Принтиране на масива\n");
        printf("4. Зареждане на масив от файл\n");
        printf("5. Принтирай първия се неповтарящ елемент\n");
        printf("6. Записване на масив във файл\n");
        printf("7. Изход\n");
        printf("Въведете избор: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                inputArray();
                break;
            case 2:
                checkElement();
                break;
            case 3:
                printArray();
                break;
            case 4:
                loadFromFile();
                break;
            case 5:
                findFirstNonRepeated();
                break;
            case 6:
                saveToFile();
                break;
            case 7:
                printf("Прекратяване....\n");
                exit(0);
            default:
                printf("Невалидна опция. Въведете опция от 1 до 7\n");
        }
    }

    return 0;
}
