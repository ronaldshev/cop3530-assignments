#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
 


struct EDGETAG;

typedef struct VERTEX 
{
char id;
bool isVisited;
struct EDGETAG* edge;
struct EDGETAG* lastEdge;
}VERTEX;

typedef struct EDGETAG
{
struct VERTEX* vertex;
struct EDGETAG* nextEdge;
}EDGE;

typedef struct VERTEXLIST
{
VERTEX* data[26];
VERTEX* head;
int size;
}VERTEXLIST;

typedef struct STACK
{
int size;
VERTEX* data[26];
VERTEX* top;
}STACK;

typedef struct QUEUE{
VERTEX* data[26];
int size;
}QUEUE;

//VERTEX LIST
void insEdge(VERTEXLIST* vList, EDGE* newEdge, char key);
void insVertex(VERTEXLIST* vList, VERTEX* newVertex);
bool search(char key, VERTEXLIST* vList);
VERTEX* getVertex(char key, VERTEXLIST* vList);
VERTEX* noSuccessors(VERTEXLIST* vList);
VERTEX* nextUnvisited(VERTEX* vertex);
void showList(VERTEXLIST* vList);





//SEARCH
void breadth(VERTEXLIST* vList);
void depth(VERTEXLIST* vList);


//SORT
void top(VERTEXLIST* vList);


//STACK
VERTEX* peek(STACK* s);
void push(VERTEX* v, STACK* stack);
void pop(STACK* s);
void sInitialize(STACK* stack);

//QUEUE
VERTEX* getFirst(QUEUE* q);
void ins(VERTEX* v, QUEUE* q);
void del(QUEUE* q);
void qInitialize(QUEUE* q);
