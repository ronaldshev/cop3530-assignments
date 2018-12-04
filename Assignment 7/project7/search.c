#include "a7.h"

bool search(char key, VERTEXLIST* vList)
{
int i=0;
bool inList=false;
for(i;i< vList->size;i++){
if(vList->data[i] -> id == key){
inList=true;
break;
}
}
return inList;
}


