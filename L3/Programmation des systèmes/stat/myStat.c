#include <stdio.h>
#include <sys/stat.h> 
#include <sys/types.h>
#include <grp.h>
#include <unistd.h>
#include<sys/sysmacros.h>
#include <pwd.h>
#include <string.h>
#include <stdlib.h>

int myStat(char *argv)
{




struct stat *buffer;


char *newpath = "./";
strcat(newpath , argv);


stat(newpath,buffer);

printf("st_ino :%ld \n ",buffer->st_ino);


return 0;

}

int main(int argc, char *argv[])
{
    if (argc <= 1)
    {
        printf("usage : put a file in argumennt for this fuction \n");
        exit(1);
    }

    struct stat buff;
    struct passwd *pass;
    struct group *grpid;

    stat(argv[1],&buff);
    pass = getpwuid(buff.st_uid);
    grpid = getgrgid(buff.st_gid);
    char * filetype ="inconnu";

    if (S_ISREG(buff.st_mode)){
        filetype= "fichier";
    }
    if (S_ISDIR(buff.st_mode)){
        filetype= "répertoire";
    }
    if (S_ISCHR(buff.st_mode)){
        filetype= "Periph Char";
    }
    if (S_ISBLK(buff.st_mode)){
        filetype= "Periph Block";
    }
    if (S_ISFIFO(buff.st_mode)){
        filetype= "FIFO/pipe\n";
    }
    if (S_ISLNK(buff.st_mode)){
        filetype= "Lien symbolique";
    }
    if (S_ISSOCK(buff.st_mode)){
        filetype= "Socket";
    }
 
 


    
    printf("%s:\n", argv[1]);
	printf("\tinode: %lu\n", buff.st_ino);
	printf("\tlinks: %ld\n", buff.st_nlink);
	printf("\tsize: %ld\n", buff.st_size);
    printf("\tBlocks: %ld\n", buff.st_blocks);
    printf("\tBlocksSize: %ld\n", buff.st_blksize);
    printf("\tDevice: %ld\n", buff.st_dev);
    printf("\tmode: %u\n", buff.st_mode);
    printf("\ttype: %s \n", filetype);
    printf("\tpermission: (0%lo) (octal) UID: (%ld/%s ) GID: (%ld/%s) \n", (unsigned long)(buff.st_mode & (~S_IFMT)), (long) buff.st_uid,pass->pw_name ,buff.st_gid,grpid->gr_name);
   
	printf("\tUid: %ld\n", buff.st_uid);
	printf("\tGid: %ld\n", buff.st_gid);
    printf("\tDevice ID: %ld\n", buff.st_rdev);
  
    
    

    return 0;
}