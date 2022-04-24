

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class Fenetre extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Gestion d'étudiant");
		
		GridPane g = new GridPane();
		Scene scene = new Scene(g,300,300);
		stage.setScene(scene);
		
		Data d = new Data();
		ArrayList<Filiere> Filieres = d.listeFiliere();
		
		ObservableList<?> obsfiliere = FXCollections.observableArrayList(Filieres);
		ChoiceBox<?> selectFiliere = new ChoiceBox<>(obsfiliere);
		
		Label l1 = new Label("Numéro : ");
		Label l2 = new Label("Nom : ");
		Label l3 = new Label("Prénom : ");
		Label l4 = new Label("Filièere : ");
		
		TextField txt1 = new TextField();
		TextField txt2 = new TextField();
		TextField txt3 = new TextField();
		
		Button bt1 = new Button("Rechercher par Num");
		Button bt2 = new Button("Ajouter étudiant");
		Button bt3 = new Button("Supprimer étudiant");
		
		g.setAlignment(Pos.CENTER);
		g.setVgap(20);
		g.setPadding(new Insets(25,25,25,25));
		g.setHgap(10);
		
		g.add(l1, 0, 0);
		g.add(l2, 0, 1);
		g.add(l3, 0, 2);
		g.add(l4, 0, 3);
		
		g.add(txt1, 1, 0);
		g.add(txt2, 1, 1);
		g.add(txt3, 1, 2);
		g.add(selectFiliere, 1, 3);
		
		g.add(bt1, 0, 4);
		g.add(bt2, 1, 4);
		g.add(bt3, 0, 5);
		
		bt1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					Etudiant et1 = d.rechercherEtudiant(Integer.parseInt(txt1.getText()));
					if(et1.getfiliere() != null) {
						
						txt2.setText(et1.getNom());
						txt3.setText(et1.getPrenom());
						int y = 0;
					    switch(et1.getfiliere().getDescription()) {
					    	case "ASEDS":
					    		y=1;
					    		break;
					    	case "DATA":
					    		y=2;
					    		break;
					    	case "AMOA":
					    		y=3;
					    		break;
					    	case "ICCN":
					    		y=4;
					    		break;
					    	case "SESNUM":
					    		y=5;
					    		break;
					    	case "ICT":
					    		y=6;
					    		break;
					    	case "CLOUD":
					    		y=7;
					    		break;
					    }					    							
						selectFiliere.getSelectionModel().select(y-1);
					}
					else {
						Alert erreur=new Alert(Alert.AlertType.ERROR);
						erreur.setTitle("Résultat introuvable!");
						erreur.setContentText("L'étudiant(e) n'existe pas");
						erreur.setGraphic(null);
						erreur.show();
					}
						
				}catch(NumberFormatException e){
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		bt3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					if(txt1.getText().equals("")){
						Alert erreur=new Alert(Alert.AlertType.ERROR);
						erreur.setTitle("Etudiant introuvable");
						erreur.setContentText("Aucun(e) étudiant(e) correspond à cet ID");
						erreur.setGraphic(null);
						erreur.show();	
					}
					else {
						Etudiant e = d.rechercherEtudiant(Integer.parseInt(txt1.getText()));
						if(e.getfiliere() !=null) {
							d.supprimerEtudiant(e);
							Alert erreur=new Alert(Alert.AlertType.INFORMATION);
							erreur.setContentText("Supression effectuée");
							erreur.setGraphic(null);
							erreur.show();	
							txt1.setText("");
							txt2.setText("");
							txt3.setText("");
							selectFiliere.setValue(null);
						}
						else {
							Alert erreur=new Alert(Alert.AlertType.ERROR);
							erreur.setTitle("Supression impossible");
							erreur.setContentText("L'étudiant n'existe pas");
							erreur.setGraphic(null);
							erreur.show();	
						}
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}			
		});
		bt2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Filiere fil = (Filiere) selectFiliere.getValue();
				if(txt1.getText().equals("")||txt2.getText().equals("")||txt3.getText().equals("")|| fil.equals(null)) {
					Alert erreur=new Alert(Alert.AlertType.ERROR);
					erreur.setTitle("Impossible d'ajout");
					erreur.setContentText("re-saisir les données correctement!");
					erreur.setGraphic(null);
					erreur.setHeaderText(" Des cases sont vides!!");
					erreur.show();
				}
				else {
					try {
						Etudiant et2 = new Etudiant(Integer.parseInt(txt1.getText()), txt2.getText(), txt3.getText(), (Filiere) fil );
					    Etudiant et3 = d.rechercherEtudiant(Integer.parseInt(txt1.getText()));
					    int y = 0;
					    switch(fil.getDescription()) {
					    	case "ASEDS":
					    		y=1;
					    		break;
					    	case "DATA":
					    		y=2;
					    		break;
					    	case "AMOA":
					    		y=3;
					    		break;
					    	case "ICCN":
					    		y=4;
					    		break;
					    	case "SESNUM":
					    		y=5;
					    		break;
					    	case "ICT":
					    		y=6;
					    		break;
					    	case "CLOUD":
					    		y=7;
					    		break;
					    		
					    }
					    if(et3.getfiliere() == null) {
					    	fil.setId_filiere(y);
					    	d.ajouterEtudiant(et2);
					    	Alert erreur=new Alert(Alert.AlertType.INFORMATION);
							erreur.setContentText("L'ajout a été éfectué avec succès");
							erreur.setGraphic(null);
							erreur.show();	
							txt1.setText("");
							txt2.setText("");
							txt3.setText("");
							selectFiliere.setValue(null);
							
					    }
					    else {
					    	Alert erreur=new Alert(Alert.AlertType.ERROR);
							erreur.setTitle("L'impossible d'ajout!");
							erreur.setContentText("L'étudiant(e) existe déjà!!");
							erreur.setGraphic(null);
							erreur.show();
					    }
					}
					catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
	  			}	
			}
					
		});
		
		stage.show();
	}
	
	
	public static void main(String[] arg) {
		launch(arg);
	}
	
}
