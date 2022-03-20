package tp_mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GestionnaireSessionsTest {
	@InjectMocks
	GestionnaireSessions sessions;
	@Mock
	Compte compte;
	@Mock
	GestionnaireComptes gestionnaireComptes;
	
	@Test
	public void testConnexionNormale() throws CompteInexistantException {
		//....
	}
	
	
	@Test
	public void testCompteInexistant() throws CompteInexistantException {		
		//....
	}
	@Test
	public void testMotDePasseInvalide() throws CompteInexistantException {
		//.....
	}
	@Test
	public void testBlocageCompte() throws CompteInexistantException {
		//.......
	}
	
	@Test
	public void testDeblocageCompte() throws CompteInexistantException {
		//Scenario : 2 tentatives infructueuses + tentative valide + tentative infructueuse (le compte ne doit être bloqué)
	}
	
	@Test
	public void testInterdictionConnexionMultipleMemeCompte() throws CompteInexistantException {
		//....
	}
	
	@Test
	public void testConnexionImpossibleCompteBloque() throws CompteInexistantException {
		//....
	}
}
