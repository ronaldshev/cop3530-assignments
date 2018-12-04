#include "my.h"

int main (int argc, char* argv[]){
	FILE* F = fopen(argv[1], "r");
	
	if(F == NULL){
		printf("Invalid file.\n");
		return 0;	
	}

	int i, size;

	fscanf(F, "%d", &size);
	int* nums = (int*)calloc(size, sizeof(int));

	for(i = 0; i < size; i++){
		fscanf(F, "%d", &nums[i]);
	}
	
	sort(size, nums);
	print(size, nums);
	
	free(nums);
	fclose(F);
	
	return 0;	
}
