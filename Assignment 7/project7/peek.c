#include "a7.h"

VERTEX* peek(STACK* stack){
if(stack->size>0)
return (stack->data[stack->size-1]);
else
return NULL;
}
