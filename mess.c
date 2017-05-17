#include<stdlib.h>
#include<stdio.h>
#include<unistd.h>
#include<sys/ipc.h>
#include<sys/sem.h>
#include<semaphore.h>
sem_t mess;
void main()
{
int s,c;
int answer;
     printf("number of student and capacity");
	 scanf("%d%d",&s&c);
	 if(s%c==0)
	 answer=s/c;
	 else
	 answer=s/c+1;
	 sem_init(&mess,0,c);
	 int i;
	  pthread_t th[answer];
	 for(i=0;i<answer;i++)
	 pthread_create(&th[i],null,func,i);
	 for(i=0;i<answer;i++)
	 pthread_join(th[i],null);
	 sem_distroy(&mess);
}
	void* func(int answer)
{
	sem_wait(&mess);
	usleep(10);
	printf("i am in mess");
    sem_post(&mess);
	printf("i am out of mess");
}

