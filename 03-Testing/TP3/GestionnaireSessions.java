package tp_mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GestionnaireSessionsTest {
	@InjectMocks
	GestionnaireSessions sessions;
	@Mock
	Compte compte;
	@Mock
	GestionnaireComptes gestionnaireComptes;
	@Spy
	CompteInexistantException erreur;
	@Disabled
	@Test
	public void testConnexionNormale() throws CompteInexistantException {
		when(gestionnaireComptes.rechercherParNomUtilisateur("user1")).thenReturn(compte);
		when(compte.validerMotPasse(ArgumentMatchers.anyString())).thenReturn(true);
		boolean connect=sessions.connecter("user1", "password");
		verify(compte,times(1)).setConnecte(true);
		assertTrue(connect);
		
	}
	
	
	@Test
	public void testCompteInexistant() throws CompteInexistantException {		
		when(gestionnaireComptes.rechercherParNomUtilisateur("user5")).thenThrow(erreur);
		boolean result =sessions.connecter("user1","password");
		verify(compte,times(0)).setConnecte(ArgumentMatchers.anyBoolean());
		assertFalse(result);
			
		
	}
	@Test
	public void testMotDePasseInvalide() throws CompteInexistantException {
		when(gestionnaireComptes.rechercherParNomUtilisateur("user4")).thenReturn(compte);
		when(compte.validerMotPasse(ArgumentMatchers.anyString())).thenReturn(false);
		boolean result=sessions.connecter("user1", "password");
		verify(compte, times(0)).setConnecte(ArgumentMatchers.anyBoolean());
		assertFalse(result);
	     
		
	}
	@Disabled
	@Test
	public void testBlocageCompte() throws CompteInexistantException {
		when(gestionnaireComptes.rechercherParNomUtilisateur("user1")).thenReturn(compte);
		when(compte.validerMotPasse(ArgumentMatchers.anyString())).thenReturn(false);
		for(int i=0;i<3;i++) {
		     sessions.connecter("user1", "password");
			
		}
		verify(compte,times(1)).setBloque(true);
		
	}
	@Disabled
	@Test
	public void testDeblocageCompte() throws CompteInexistantException {
		//Scenario : 2 tentatives infructueuses + tentative valide + tentative infructueuse (le compte ne doit être bloqué)
		when(gestionnaireComptes.rechercherParNomUtilisateur("user1")).thenReturn(compte);
		when(compte.validerMotPasse("wrong")).thenReturn(false);
		when(compte.validerMotPasse("correct")).thenReturn(true);
		sessions.connecter("user1", "wrong");
		sessions.connecter("user1", "wrong");
		sessions.connecter("user1", "correct");
		sessions.connecter("user1", "wrong");
		verify(compte,times(1)).setBloque(true);
		
		
	}
	@Disabled
	@Test
	public void testInterdictionConnexionMultipleMemeCompte() throws CompteInexistantException {
		//....
		compte.setConnecte(true);
		when(gestionnaireComptes.rechercherParNomUtilisateur("user1")).thenReturn(compte);
		when(compte.validerMotPasse("password")).thenReturn(true);
		boolean result=sessions.connecter("user1", "password");
		verify(compte,times(1)).setConnecte(true);
		assertFalse(result);
	}
	@Disabled
	@Test
	public void testConnexionImpossibleCompteBloque() throws CompteInexistantException {
		//....
		when(gestionnaireComptes.rechercherParNomUtilisateur("user1")).thenReturn(compte);
		compte.setBloque(true);
		boolean result=sessions.connecter("user1","password");
		verify(compte,times(0)).setConnecte(true);
		assertFalse(result);
	}
}