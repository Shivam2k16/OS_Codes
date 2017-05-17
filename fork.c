#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>

int main()
{
 pid_t pid, fd[2];

 pipe(fd);
 pid = fork();

 if(pid == 0)
 {

  int fd2[2];
  pipe(fd2);

  pid = fork();

  if(pid == 0)
  {
    int *a = calloc(1,sizeof(int));
    close(fd2[0]);
    *a = 1;
    write(fd2[1], a, sizeof(int));
  }

  else
  {
    wait(0);
    close(fd2[1]);
    int *b = calloc(1, sizeof(int));
    read(fd2[0], b, sizeof(int));
    close(fd2[0]);

   *b += 2;

    write(fd[1], b, sizeof(int));
  }
 }

else
 {
   wait(0);
   close(fd[1]);
   int *c = calloc(1, sizeof(int));

   read(fd[0], c, sizeof(int));
   close(fd[0]);

   *c += 3;

   printf("sum = %d" , *c);
 }
}
