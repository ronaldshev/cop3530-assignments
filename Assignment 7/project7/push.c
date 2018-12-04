#include "a7.h"

void push(VERTEX* v, STACK* stack){
if(stack->size<26){
stack->data[stack->size++]=v;
}
}
