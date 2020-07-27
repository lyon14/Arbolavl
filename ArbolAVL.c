#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct nodo
{
  int dato;
  struct nodo* siguiente;
  struct nodo* atras;
}nodo;

nodo* primero = NULL;
nodo* ultimo = NULL;

void Insertar(int v);
void Ordenamiento();


int main(){

  Insertar(20);
  Insertar(30);
  Insertar(23);
  Insertar(34);
  Insertar(15);
  Insertar(11);
  Insertar(3);
  Insertar(1);

  
  return 0;
}

void Insertar(int v){

  nodo* nuevo=(nodo*)malloc(sizeof(nodo));
  nuevo->dato = v;
  printf("%d ",nuevo->dato);

  if(primero==NULL){
    primero=nuevo;
    primero->siguiente=NULL;
    primero->atras=NULL;
    ultimo=nuevo;
  }else{
    ultimo->siguiente=nuevo;
    nuevo->siguiente=NULL;
    nuevo->atras=ultimo;
    ultimo=nuevo;
  }
}

void Ordenamiento(){
  
}