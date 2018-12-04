#include "a7.h"

void breadth(VERTEXLIST* vList){
int count=0;
int i=0;
vList->data[0]->isVisited=true;
VERTEX* current=vList->data[0];
QUEUE* q= (QUEUE*)malloc(sizeof(QUEUE));
qInitialize(q); 







//search

printf("Breadth First Search: ");

printf("%c", current->id);
count++;
ins(current, q);

while(getFirst(q)!=NULL && count< vList->size){
current=nextUnvisited(getFirst(q));
if(current==NULL){
del(q);
}
else{
current->isVisited=true;
ins(current, q);
printf("%c",current->id);
count++;

}
}

for(i=0;i< vList->size;i++){
vList->data[i]->isVisited=false;
}

printf("\n\n");

}
