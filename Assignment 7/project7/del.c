#include "a7.h"

void del(QUEUE* q){
int i=0;
if(q->size>0){
for(i=0;i< q->size-1;i++){
q->data[i]=q->data[i+1];
}
q->size--;
}
}
