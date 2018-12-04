#include "a7.h"

VERTEX* noSuccessors(VERTEXLIST* vList){
    bool hasSuccessor = true;
   int i=0;
    VERTEX* current = vList -> data[0];
    
    while(current != NULL && hasSuccessor){
        hasSuccessor = false;
        EDGE* currentEdge = current -> edge;
        if(current->isVisited) {
            hasSuccessor = true;
        } else if (currentEdge == NULL) {
            break;
        } else {
            while(currentEdge != NULL && !hasSuccessor){
                if(!(currentEdge -> vertex -> isVisited)){ 
                    hasSuccessor = true;           
                }else{
                    hasSuccessor = false;
                }
                currentEdge = currentEdge -> nextEdge;
            }
        }
        if(hasSuccessor) {
            current = vList->data[i++];
        }
    }
    if(hasSuccessor) {
        current = NULL;
    }
    
    return current;
}
