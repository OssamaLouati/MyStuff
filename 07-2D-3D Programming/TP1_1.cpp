#include<GL/glut.h>
#include<stdio.h>

GLfloat longueur=0.1;                                                   // initialisation variable Longueur

void Dessin(void) 
{
	glClear(GL_COLOR_BUFFER_BIT); 

glColor3f(1.0, 0.0, 0.0);                                            // Couleur du dessin Rouge 
glBegin(GL_POLYGON); 
glVertex2f(-longueur/2,-longueur/2);
glVertex2f(-longueur/2,longueur/2);
glVertex2f(longueur/2,longueur/2);
glVertex2f(longueur/2,-longueur/2);
glEnd() ; 
glutSwapBuffers();

} 

void Clavier( unsigned char key, int x, int y) 
{
switch(key)
{

case '+' : longueur+= 0.05;    break;                  // augmenter la taille du carr�
case '-'  : longueur-= 0.05;     break;                  //r�duire la taille du carr�
default  : printf(" Cette Touche: %c\n ne peut etre consideree; Son code ASCII : %d \n",key,key); break;  // affiche les autres caract�res appuy�s et leurs code ACSII
case 's' : exit(0);       break;
  }
glutPostRedisplay();                          // r�-afficher
}


int main(int argc, char ** argv) 
  {
  glutInit(& argc, argv);                    //Initialiser GLUT
  glutInitDisplayMode(GLUT_RGBA |GLUT_DOUBLE);    // Mode d'affichage par d�faut
  glutCreateWindow("Ma premi�re Fen�tre OpenGL") ;  //cr�ation de la fen�tre
  glClearColor(0.5,0.5,0.5,1.0) ;                      //Couleur de l'arri�re plan
  glutInitWindowPosition(100, 100);               //position de la fen�tre 
  glutInitWindowSize(500,500);                       //taille initiale de la fen�tre
  glutDisplayFunc(Dessin) ; 
  glutKeyboardFunc(Clavier);
  glutMainLoop() ;
  return(0);
  }

