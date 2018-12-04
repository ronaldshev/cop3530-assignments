
#include "a7.h"

void insVertex(VERTEXLIST* vList, VERTEX* newVertex){

if(vList->size<26){
vList->data[vList->size++]=newVertex;
}
}
