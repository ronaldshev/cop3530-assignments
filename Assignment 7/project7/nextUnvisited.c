#include "a7.h"

VERTEX* nextUnvisited(VERTEX* vertex){
    VERTEX* result = NULL;
    EDGE* tempEdge = vertex -> edge;
    bool found = false;
    
        while(tempEdge != NULL && !found){
        if(!(tempEdge -> vertex -> isVisited)){
            result = tempEdge -> vertex;
            found = true;
        }else{
            tempEdge = tempEdge -> nextEdge;

 }
}

    return result;
}
