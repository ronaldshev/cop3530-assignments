#include "a7.h"

void top(VERTEXLIST* vList){

    VERTEX* current;
    int count = 0;
    int i=vList->size;
    char string[i--];
    while(true){
        current = noSuccessors(vList);
        if(current == NULL){
            break;
        }
        string[count] = current -> id;
        current -> isVisited = true;
        count++;
    }
 
printf("Topological Sort: ");   
for(i;i>=0;i--){
printf("%c",string[i]);
}
printf("\n\n");
   

}
