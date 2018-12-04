#include "my.h"

void print(int size, int nums[size]){
	int i = 0;

	printf("What index would you like to see?\n");
	
	while(i != -1){
		scanf("%d", &i);
		if((i >= size) || (i == -1)){
			printf("Invalid index.\n");
			break;
		}
		else{
			printf("Number at index %d: %d.\n", i, nums[i]);
		}
	}
	return;
}
