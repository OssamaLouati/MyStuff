#include<GL/glut.h>
#include <windows.h>
#include<stdio.h>

GLfloat length=0.1 ; 
GLfloat dvert=0.1; //deplacement vertical
GLfloat dhoriz=0.1; //déplacement horizental
GLfloat r=1; //composante couleur rouge
GLfloat v=0; //composante couleur verte
GLfloat b=0; //composante couleur bleu

void display() 
{
glClear(GL_COLOR_BUFFER_BIT); 

glColor3f(r, v, b);//couleur variable
glMatrixMode(GL_PROJECTION); //
glLoadIdentity(); //ces deux fonctions calculent automatiq la position du repère sinon le carré bouge d'une manière aléatoire.
glTranslated(dhoriz,dvert,0.0);// Translation variable
glBegin(GL_POLYGON); 
glVertex2f(-length/2,-length/2);//taille du polygone variable
glVertex2f(-length/2,length/2);
glVertex2f(length/2,length/2);
glVertex2f(length/2,-length/2);
glEnd() ; 
glutSwapBuffers();
} 
 
void clavier2( int key, int x, int y)
  {switch (key){
		case GLUT_KEY_RIGHT : dhoriz+=0.1;break;     //déplacement à gauche
		case GLUT_KEY_LEFT  : dhoriz-=0.1;break;     //déplacement à droite
        	case GLUT_KEY_UP    : dvert+=0.1;break;      // en haut
		case GLUT_KEY_DOWN  : dvert-=0.1;break;      //en bat
		case GLUT_KEY_F1    : r=0;v=1;b=0;break;     //couler verte
       		 case GLUT_KEY_F2    : r=0;v=0;b=1;break;     //couleur bleu
       		 case GLUT_KEY_F3    : r=0.5;v=0.5;b=0;break; // couleur jaune
		case GLUT_KEY_F4    : r=1;v=0;b=1;
		break;     //couleur magenta
		case GLUT_KEY_F5    : exit(0);break;         //quitter le programme
	}
 glutPostRedisplay(); //re-aapliquer ces changements au carré
  }
  
  
void clavier1( unsigned char key, int x, int y) 
  {switch(key){
                  case '+' : length+= 0.05; break; // augmenter la taille du carré
                  case '-' : length-= 0.05; break; //réduire la taille du carré
                  default  : printf(" Cette Touche: %c\n n est pas consideree; Son code ASCII : %d \n",key,key); break;                  
                  // affiche les autre caractères appuiyé et le code ACSII}
                  case 's' : exit(0);break;
  if( length> 1) length= 1;
  else if( length< 0) length= 0 ;
  }
    glutPostRedisplay();  // réaffiche
}
  
  int main(int argc, char ** argv) 
  {
  glutInit(& argc, argv); //Initialiser GLUT
  glutInitDisplayMode(GLUT_RGBA |GLUT_DOUBLE); 
  glutCreateWindow("Ma première Fenêtre OpenGL") ;
  glClearColor(1.0,1.0,1.0,1.0) ; 
  glutInitWindowPosition(100, 100); 
  glutInitWindowSize(500,500); 
  glutDisplayFunc(display) ; 
  glutKeyboardFunc(clavier1);
  glutSpecialFunc(clavier2);
  glutMainLoop() ;
  return(0);
  }
