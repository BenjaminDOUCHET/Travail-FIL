
#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<unistd.h>
#include<assert.h>



int myRead(int buffer_size , int fd){
    char *buffer;
    buffer = malloc(buffer_size); assert(buffer !=NULL);/* j'alloue de la mémoire pour le buffer et je vérifie qeue ça s'est bien passé*/
    ssize_t bytesRead;
    /*tant qu'on arrive à lire quelque chose*/
    while((bytesRead = read(fd,buffer,buffer_size))>0 ){ 
       if(write(STDOUT_FILENO,buffer,bytesRead)!= bytesRead){
           return -1;
       }; /*on transfert du buffer ce qui a été lu*/
    }
    free(buffer); /*je libère la mémoire du buffer*/
    return (bytesRead <0)?-1:0;
}





int main(int argc, char *argv[]) {
    int buffer_size;
    int fd;
    if (argc <= 2)
    {
        printf("usage : need 2 args , 1st = buffer size , 2nd = file path \n");
        exit(1);
    }

    fd = open(argv[2], O_RDONLY);assert(fd>=0); /*j'ouvre mon fichier dans le file descriptor*/
    
    buffer_size = atoi(argv[1]); /*je calcule ma taille de buffer*/
    

    if(myRead(buffer_size ,fd)){
        fprintf(stderr,"failed to read the input" );
    } ; /*je fais ma lecture*/
    
    close(fd); /*je referme mon fichier */
    

    return 0;
}