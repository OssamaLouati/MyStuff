# include < stdio.h>
# include < unistd.h> // pour sleep
# include < pthread.h> // pour les threads
# include < semaphore.h> // pour les sémaphores

// nombre de philosophes
#define N 5 
// philosophe de gauche de i
#define LEFT (phnum + 4)%N
// philosophe de droite de i
#define RIGHT (phnum + 1)%N 
#define Free 1
#define Busy 0

//déclarer les états initiaux des fourchettes
int fourch [N] = { Free , Free , Free ,Free , Free } ;

// creer un mutex
sem_t mutex ;


int main ( )
{
	int NumPhi[N] = { 0 , 1 , 2 , 3 , 4 } ;
	int i ;
	pthread_t ph[N] ;

	// initialiser les semaphores
	sem_init(&mutex , 0 , 1 ) ;
	
	// creations des N philosophes
	for ( i = 0 ; i<N; i ++)

	// create philosopher processes
	pthread_create(&ph[ i ] ,NULL, philospher ,&(NumPhi[ i ] ) ) ;
	//attendre la fin des threads
	
	i =0;
	for(i = 0; i < N; i++)
            //créer un mechanisme pour attendre le thread se termine
			pthread_join(thread_id[i], NULL);
			printf( " fin des threads \n" ) ;
	return 0;
	while ( i<N && ( pthread_join(ph[ i ++],NULL) = = 0 ));
	printf ( " fin des threads \n" ) ;
	return 0 ;
}

// La fonction de chaque philosophe
void * philospher( void *num)
{
int i =* ( int *) num;
int nb = 2 ;
while ( nb )
{
    // penser
    sleep( 1 ) ;
    // essayer de prendre les fourchettes pour manger
    int j=test(i);
    if(j==0) nb-- ;

    // accéder à la section critique
    sem_wait(&mutex ) ;

 }



int test(int phnum){
       if( fourch [G] && fourch [ phnum ] )
{

	// prendrer les fourchettes
	fourch [LEFT] = 0 ;
	fourch [ phnum ] = 0 ;
	printf( " philosophe [%d ] mange \n" , i ) ;
	//quitter la section critique
	sem_post(&mutex ) ;

	// manger
	sleep( 1 ) ;
	
	sem_wait(&mutex ) ;

	// élibrer les fourchettes
	fourch [LEFT] = 1 ;
	fourch [phnum] = 1 ;
	printf( " philosophe [%d ] a fini de manger\n" , i ) ;

	//quitter la section critique
	sem_post(&mutex ) ;
	return 0;
}
else sem_post(&mutex ) ;
return 1;
}
}