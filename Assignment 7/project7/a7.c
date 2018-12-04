// Ashton Goethe, 4-15-18
// This code searches(breadth-first and depth-first) and sorts(topilogical) a directed graph using linked lists. 

#include "a7.h"



int main(int argc ,char* argv[])
{


char first,second;


VERTEXLIST* List=(VERTEXLIST*)malloc(sizeof(VERTEXLIST));
List->size=0;
List -> head =NULL;




if(fopen(argv[1],"r")==NULL){
printf("Invalid file\n");
exit(1);
}
FILE* f=fopen(argv[1],"r");
while(fscanf(f, "%c %c\n", &first, &second) != EOF){


	

 if(!search(first, List)) {

VERTEX* new = malloc(sizeof(VERTEX));             
		    new -> id = first;           
	            new -> edge = NULL;
		    new -> lastEdge=new->edge;   
                    new -> isVisited = false;
                    
		    

              insVertex(List, new);              

		}
		
		if(!search(second, List)) {			

               VERTEX* new = malloc(sizeof(VERTEX));
		    new -> id = second;
		    new -> edge = NULL;
		    new->lastEdge=new->edge;
                    new -> isVisited = false;


		    insVertex(List, new);
       
                 

		}

    EDGE* e =(EDGE*)malloc(sizeof(EDGE));
          
       e->vertex = getVertex(second, List);                 
       e->nextEdge = NULL;                
       insEdge(List,e, first);          

}

showList(List);  
depth(List);     
breadth(List);   
top(List);       
fclose(f);




return 0;
}
