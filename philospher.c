#include<stdio.h>
#include<pthread.h>
#include<semaphore.h>
#include<stdlib.h>
pthread_mutex_t mutex;
sem_t control;
sem_t chopsticks[5];

void* eat(void* arg){
    long i = (long)arg;
    sem_wait(&control);
    int x,y;
    sem_getvalue(&chopsticks[i],&x);
    sem_getvalue(&chopsticks[(i+1)%5],&y);
    if(x==1 && y==1){
        sem_wait(&chopsticks[i]);
        sem_wait(&chopsticks[(i+1)%5]);
        printf("%lu philosper is eating\n",i);

    }
    sem_post(&control);
    sem_post(&chopsticks[i]);
    sem_post(&chopsticks[(i+1)%5]);
    printf("%lu done eating\n",i);

}
int main()
{
    int philosphers;
    printf("Enter the number of philosphers\n");
    scanf("%d",&philosphers);
    pthread_t philos[philosphers];
    //pthread_mutex chopsticks = (pthread_t *)malloc(sizeof(pthread_t)*philosphers);
    sem_init(&control,0,2);
    long i;
    for(i=0;i<philosphers;i++)
        sem_init(&chopsticks[i],0,1);
    
    for(i=0;i<philosphers;i++)
        pthread_create(&philos[i],NULL,*eat,(void*)i);
    for(i=0;i<philosphers;i++)
        pthread_join(philos[i],NULL);
    for(i=0;i<philosphers;i++)
        sem_close(&chopsticks[i]);
    sem_close(&control);
}