#include<stdio.h>
#include<GL/glut.h>
GLfloat dvert=0; //deplacement vertical
GLfloat dhoriz=0; //déplacement horizental
GLfloat dprof=-0.5; //déplacement proffondeur
GLint dtheta=1; //rotation autour de i
GLint dphi=1; //rotation autour de j
GLint dgama=0; //rotation autour de k
GLfloat alpha=0.5; //echelle vertical
GLfloat beta=0.5; //echelle horizental
GLfloat gama=0.5; //echelle proffondeur
GLfloat angle =30;
int maj = 5;        // refresh interval in milliseconds [NEW]

//Création de la scène
void display() 
{
glClear (GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT) ;
glClearColor(0.5,0.5,0.5,0.0);//couleur de l'arrière plan (gris)
glClear(GL_COLOR_BUFFER_BIT); //Initialisaion
glLoadIdentity();//Initialisation
glRotatef(angle,dtheta,dphi,dgama);//rotation variable
glTranslatef(dhoriz,dvert,dprof);// Translation variable
glScalef(alpha,beta,gama);//chang d'echellle
//Déssiner un Cube
glBegin(GL_QUADS); 
 {   glColor3f(0.0,1.0,0.0);      // Couleur verte
      glVertex3f( 0.3, 0.3,-0.3);  // Haut droit du quadrilatere (Haut)
      glVertex3f(-0.3, 0.3,-0.3);  // Haut gauche du quadrilatere (Haut)
      glVertex3f(-0.3, 0.3, 0.3);  // Bas gauche du quadrilatere (Haut)
      glVertex3f( 0.3, 0.3, 0.3);  // Bas droit du quadrilatere (Haut)
	
     glColor3f(1.0,0.5,0.0);      // Couleur orange
      glVertex3f( 0.3,-0.3, 0.3);  // Haut droit du quadrilatere (Bas)
      glVertex3f(-0.3,-0.3, 0.3);  // Haut gauche du quadrilatere (Bas)
      glVertex3f(-0.3,-0.3,-0.3);  // Bas gauche du quadrilatere (Bas)
      glVertex3f( 0.3,-0.3,-0.3);  // Bas droit du quadrilatere (Bas)
            
      glColor3f(1.0,0.0,0.0);       // Couleur rouge
       glVertex3f( 0.3, 0.3, 0.3);   // Haut droit du quadrilatere (Avant)
       glVertex3f(-0.3, 0.3, 0.3);   // Haut gauche du quadrilatere (Avant)
       glVertex3f(-0.3,-0.3, 0.3);   // Bas gauche du quadrilatere (Avant)
       glVertex3f( 0.3,-0.3, 0.3);   // Bas droit du quadrilatere (Avant)       
       
      glColor3f(1.0,1.0,0.0);      // Couleur jaune
       glVertex3f( 0.3,-0.3,-0.3);  // Haut droit du quadrilatere (Arriere)
       glVertex3f(-0.3,-0.3,-0.3);  // Haut gauche du quadrilatere (Arriere)
       glVertex3f(-0.3, 0.3,-0.3);  // Bas gauche du quadrilatere (Arriere)
       glVertex3f( 0.3, 0.3,-0.3);  // Bas droit du quadrilatere (Arriere)    
            
      glColor3f(0.0,0.0,1.0);      // Couleur bleue
       glVertex3f(-0.3, 0.3, 0.3);  // Haut droit du quadrilatere (Droite)
       glVertex3f(-0.3, 0.3,-0.3);  // Haut gauche du quadrilatere (Droite)
       glVertex3f(-0.3,-0.3,-0.3);  // Bas gauche du quadrilatere (Droite)
       glVertex3f(-0.3,-0.3, 0.3);  // Bas droit du quadrilatere (Droite)
       
       
     glColor3f(1.0,0.0,1.0);      // Couleur violette
      glVertex3f( 0.3, 0.3,-0.3);  // Haut droit du quadrilatere (Gauche)
      glVertex3f( 0.3, 0.3, 0.3);  // Haut gauche du quadrilatere (Gauche)
      glVertex3f( 0.3,-0.3, 0.3);  // Bas gauche du quadrilatere (Gauche)
      glVertex3f( 0.3,-0.3,-0.3);  // Bas droit du quadrilatere (Gauche)
   }
   glEnd();                           // Fin du dessin des quadrilateres
glutSwapBuffers();
}


void clavier2( int key, int x, int y)
  {switch (key){
		case GLUT_KEY_RIGHT : dhoriz+=0.1;break;     //déplacement à gauche
		case GLUT_KEY_LEFT  : dhoriz-=0.1;break;     //déplacement à droite
        	case GLUT_KEY_UP    : dvert+=0.1;break;      // en haut
		case GLUT_KEY_DOWN  : dvert-=0.1;break;      //en bat
		
		case GLUT_KEY_F1    : dtheta=1;dphi=1;dgama=0;angle+=10;break;     //rotation autour de i
        	case GLUT_KEY_F2    : dtheta=0;dphi=1;dgama=1;angle+=10;break;     //rotation autour de j
       		case GLUT_KEY_F3    : dtheta=1;dphi=0;dgama=1;angle+=10;break; // rotation autour de k
        
		case GLUT_KEY_F6    : alpha*=2;beta*=1;gama*=1;break;     //facteur d'echell en X
		case GLUT_KEY_F7    : alpha*=1;beta*=2;gama*=1;break;     //facteur d'echell en Y
		case GLUT_KEY_F8    : alpha*=1;beta*=1;gama*=2;break;     //facteur d'echell en Z
	
		case GLUT_KEY_F5    : exit(0);break;         //quitter le programme
	}
 glutPostRedisplay(); //re-aapliquer ces changements au carré
  } 
  
//Programme Principal
int main(int argc, char ** argv) 
  {
  glutInit(& argc, argv);
  glutInitDisplayMode(GLUT_RGBA |GLUT_DOUBLE);
  glutCreateWindow(argv[0]) ;
  glutInitWindowPosition(100, 100); //position de la fenetre
  glutInitWindowSize(500,500); //taille de la fenetre
  glEnable(GL_CULL_FACE);//Ne pas afficher les faces cachées de l'objet
  glutDisplayFunc(display) ;// appel à la fonction d'afichage
  glutSpecialFunc(clavier2);
  glutMainLoop();  
  return(0);
  }
