/*
*  DictionaryClient.c
*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include "Dictionary.c"

void doIt(char* s, LinkedList ye, FILE* in, FILE* out);

int main(int argc, char* argv[]){
   FILE* in;  /* file handle for input */  
   FILE* out; /* file handle for output */
   char word[256]; /* char array to store words from input file */

   /* check command line for correct number of arguments */
   if( argc != 3 ){
      printf("Usage: %s <input file> <output file>\n", argv[0]);
      exit(EXIT_FAILURE);
   }

   /* open input file for reading */
   in = fopen(argv[1], "r");
   if( in==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   /* open output file for writing */
   out = fopen(argv[2], "w");
   if( out==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }

   LinkedList ye = newLinkedList();
   while(fscanf(in, " %s", word) != EOF ){
      doIt(word, ye, in, out);
   }

   /* close input and output files */
   fclose(in);
   fclose(out);

   return(EXIT_SUCCESS);
}
void doIt(char* s, LinkedList ye, FILE* in, FILE* out){
  if(s[0] == 'p'){
    printLinkedList(out, ye);
  }else if(s[0] == 'i'){
    int i=0;
    fscanf(in, "%d", &i);
    insert(i, ye);
    fprintf(out, "%s %d\n", "inserted", i);
  }else if(s[0] == 'f'){
    int i=0;
    int *j = 0;
    fscanf(in, "%d", &i);
    j = find(i, ye);
    if(j == NULL){
      fprintf(out, "%d %s\n", i, "not present");
    }else{
      fprintf(out, "%d %s\n", i, "present");
    }
  }else if(s[0] == 'd'){
    int i=0;
    fscanf(in, "%d", &i);
    delete(i, ye);
    fprintf(out, "%s %d\n", "deleted", i);
  }
}