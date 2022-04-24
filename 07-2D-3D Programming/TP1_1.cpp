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

case '+' : longueur+= 0.05;    break;                  // augmenter la taille du carré
case '-'  : longueur-= 0.05;     break;                  //réduire la taille du carré
default  : printf(" Cette Touche: %c\n ne peut etre consideree; Son code ASCII : %d \n",key,key); break;  // affiche les autres caractères appuyés et leurs code ACSII
case 's' : exit(0);       break;
  }
glutPostRedisplay();                          // ré-afficher
}


int main(int argc, char ** argv) 
  {
  glutInit(& argc, argv);                    //Initialiser GLUT
  glutInitDisplayMode(GLUT_RGBA |GLUT_DOUBLE);    // Mode d'affichage par défaut
  glutCreateWindow("Ma première Fenêtre OpenGL") ;  //création de la fenêtre
  glClearColor(0.5,0.5,0.5,1.0) ;                      //Couleur de l'arrière plan
  glutInitWindowPosition(100, 100);               //position de la fenêtre 
  glutInitWindowSize(500,500);                       //taille initiale de la fenêtre
  glutDisplayFunc(Dessin) ; 
  glutKeyboardFunc(Clavier);
  glutMainLoop() ;
  return(0);
  }

