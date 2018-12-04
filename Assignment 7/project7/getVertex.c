#include "a7.h"


VERTEX* getVertex(char key, VERTEXLIST* vList){
    int i=0;
    bool keyFound = false;
   VERTEX* current;
    
    for(i;i< vList -> size;i++){ 
        if(vList->data[i] -> id == key){
           current= vList->data[i];
           break;
         } 
         }
           
    
        
    
   return current; 
}
