#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>

#define N 5
#define THINKING 2
#define HUNGRY 1
#define EATING 0
#define LEFT (phnum + 4) % N
#define RIGHT (phnum + 1) % N

int state[N];
int phil[N] = { 0, 1, 2, 3, 4 };

// creer un mutex
sem_t mutex;
// creer des semaphores pour chaque fourchette
sem_t Philo[N];

void test(int phnum)
{
	if (state[phnum] == HUNGRY
		&& state[LEFT] != EATING
		&& state[RIGHT] != EATING) {
		// déclare qu'un philosophe mange
		state[phnum] = EATING;

		sleep(2);

		printf("Philosopher %d takes fork %d and %d\n",
					phnum + 1, LEFT + 1, phnum + 1);

		printf("Philosopher %d is Eating\n", phnum + 1);


		// utiliser semaphore pour réveiller les philosophes affamés lorsque le philosophe depose ses fourchettes
		sem_post(&Philo[phnum]);
	}
}

// prendrer les fourchettes
void take_fork(int phnum)
{
	// accéder à la section critique
	sem_wait(&mutex);

	// déclare qu'un philosophe est faim
	state[phnum] = HUNGRY;

	printf("Philosopher %d is Hungry\n", phnum + 1);

	// le philosophe mange si ses voisins ne mangent pas
	test(phnum);

	//quitter la section critique
	sem_post(&mutex);

	// si le philosophe est incapable de manger il doit attendre d'être signalé
	sem_wait(&Philo[phnum]);

	sleep(1);
}

// deposer les fourchettes
void put_fork(int phnum)
{
	// accéder à la section critique
	sem_wait(&mutex);

	// déclare qu'un philosophe pense
	state[phnum] = THINKING;

	printf("Philosopher %d putting fork %d and %d down\n",
		phnum + 1, LEFT + 1, phnum + 1);
	printf("Philosopher %d is thinking\n", phnum + 1);

	//tester si le philosophes a gauche peut manger
	test(LEFT);

	//tester si le philosophes a droite peut manger
	test(RIGHT);

	//quitter la section critique
	sem_post(&mutex);
}

void* philosopher(void* num)
{

	while (1) {

		int* i = num;

		sleep(1);
		//s'il est possible le philosophe prend les fourchettes

		take_fork(*i);

		sleep(0);

		//le philosophe depose les fourchettes
		put_fork(*i);
	}
}

int main()
{

	int i;
	pthread_t thread_id[N];

	// initialiser les sémaphores
	sem_init(&mutex, 0, 1);

	for (i = 0; i < N; i++)

		sem_init(&Philo[i], 0, 0);

	for (i = 0; i < N; i++) {

		// créer des processus philosophes
		pthread_create(&thread_id[i], NULL,philosopher, &phil[i]);

		printf("Philosopher %d is thinking\n", i + 1);
	}

	for (i = 0; i < N; i++)
        //créer un mechanisme pour attendre le thread se termine
		pthread_join(thread_id[i], NULL);
}
