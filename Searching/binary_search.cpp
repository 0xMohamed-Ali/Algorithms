#include <iostream>
using namespace std;

int binarySearch(int array[], int size, int target) {
    int low = 0;
    int high = size - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2; // Avoids overflow

        if (array[mid] == target) {
            return mid; // Target found
        }
        else if (array[mid] < target) {
            low = mid + 1; // Search right half
        }
        else {
            high = mid - 1; // Search left half
        }
    }

    return -1; // Target not found
}
