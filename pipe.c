#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>

int main()
{
 pid_t pid, fd[2];
char ch[12];
 pipe(fd);
 pid = fork();
 
 if(pid == 0)
 {
  
  int fd2[2];
  pipe(fd2);
  
  pid = fork();

  if(pid == 0)
  { close(fd2[0]);
    
    write(fd2[1], "world", 12);
  }
  
  else
  {
    wait(0);
    close(fd2[1]);
   
    read(fd2[0], ch, 12);
    close(fd2[0]);
    

    
    write(fd[1], "hellow", 12);
  } 
  printf("%s",ch[12]);
 }