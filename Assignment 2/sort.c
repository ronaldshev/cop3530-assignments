#include "my.h"

void sort(int size, int nums[size]){
	int i, j, temp;
	
	for (i = 0; i < (size - 1); i++){
		for(j = 1; j < (size - 1); j += 2){
			if(nums[j] > nums[j+1]){
				temp = nums[j];
				nums[j] = nums[j+1];
				nums[j+1] = temp;
			}
		}
		for(j = 0; j < (size - 1); j += 2){
			if(nums[j] > nums[j+1]){
				temp = nums[j];
				nums[j] = nums[j+1];
				nums[j+1] = temp;
			}
		}
	}
	
	return;
}
