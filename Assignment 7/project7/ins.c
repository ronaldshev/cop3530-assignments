#include "a7.h"

void ins(VERTEX*v ,QUEUE* q){
if(q->size<26){
q->data[q->size++]=v;
}
}
