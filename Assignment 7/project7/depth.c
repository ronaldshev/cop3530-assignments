#include "a7.h"

void depth(VERTEXLIST* vList){
    
    STACK* stack = malloc(sizeof(STACK));
    vList -> data[0] -> isVisited = true;
    int i;
   int count=0;
    VERTEX* tempVertex = vList -> data[0];
    
   
  

    
    i=0;
    sInitialize(stack);
    

    
    
   
   printf("Depth First Search: ");

    
push(tempVertex,stack);
printf("%c",tempVertex->id);    
count++;

while(peek(stack)!=NULL && count< vList ->size){
tempVertex=nextUnvisited(peek(stack));
if(tempVertex==NULL){                   
                       
pop(stack);
                            
}
else{                                 
tempVertex->isVisited=true;           
printf("%c",tempVertex->id);        
count++;
push(tempVertex, stack);              
}
}

    for(i;i< vList->size ; i++){
      vList->data[i]->isVisited=false;
    }
    
   printf("\n\n");
    
}



