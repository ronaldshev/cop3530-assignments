#include "a7.h"

void showList(VERTEXLIST* vList){
int i=0;
printf("------------\nVertex List\n------------\n");

for(i; i<vList->size ;i++){
EDGE* e= vList->data[i]->edge;
printf("%c",vList->data[i]->id);
while(e!=NULL){
printf("->%c",e->vertex->id);
e=e->nextEdge;
}
printf("\n");
}
printf("\n");

}
