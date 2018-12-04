#include "a7.h"

void insEdge(VERTEXLIST* vList, EDGE* newEdge, char key){
bool found = false;
int i=0;
VERTEX* current = vList->data[0];


    

while(i < vList-> size){
if(vList->data[i]->id==key){
current=vList->data[i];
break;
}             
i++;
}

    if(current->lastEdge!=NULL)
{
current->lastEdge->nextEdge=newEdge;
}
else{
current->edge=newEdge;
}
current->lastEdge=newEdge;


 return;
}

