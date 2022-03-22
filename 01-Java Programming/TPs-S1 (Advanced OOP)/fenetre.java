package App;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class fenetre extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Gestion des étudiants");
		
		Label l1 = new Label("Numéro étudiant:");
		Label l2 = new Label("Nom:");
		Label l3 = new Label("Prénom:");
		Label l4 = new Label("Filière:");
		
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		
		Button btn1 = new Button("Rechercher par num");
		Button btn2 = new Button("Ajouter étudiant");
		Button btn3 = new Button("Supprimer étudiant");
		
		Data data = new Data();
		ArrayList<Filiere> Filieres = data.listeFiliere();
		ObservableList<?> observableFiliere= FXCollections.observableArrayList(Filieres);
		ChoiceBox<?> choixFiliere = new ChoiceBox<>(observableFiliere);
		
		
		
        GridPane g = new GridPane();
		
		Scene scene = new Scene(g,300,275);
		stage.setScene(scene);
		
		g.setAlignment(Pos.CENTER);
		g.setHgap(10);
		g.setVgap(10);
		g.setPadding(new Insets(25,30,25,25));
		
		g.add(l1, 0, 0);
		g.add(t1, 1, 0);
		g.add(l2, 0, 1);
		g.add(t2, 1, 1);
		g.add(l3, 0, 2);
		g.add(t3, 1, 2);
		g.add(l4, 0, 3);
		g.add(choixFiliere, 1, 3);
		g.add(btn1,0, 4);
		g.add(btn2, 1, 4);
		g.add(btn3,0, 5);
		
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Filiere filiere=(Filiere) choixFiliere.getValue();
					if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")|| filiere.equals(null)) {
						Alert erreur=new Alert(Alert.AlertType.ERROR);
						erreur.setTitle("ajout impossible");
						erreur.setContentText("reessayer avec une autre valeur");
						erreur.setGraphic(null);
						erreur.setHeaderText("l'une des cases est vide");
						erreur.show();						
					}
					else {
					//	Etudiant étudiant;
						try {
							Etudiant étudiant = new Etudiant(Integer.parseInt(t1.getText()),t2.getText(),t3.getText(),(Filiere) choixFiliere.getValue());
							System.out.println(étudiant);
							Etudiant e = data.rechercherEtudiant(Integer.parseInt(t1.getText()));
							System.out.println(e);
							if(e.getNom()==null) {
								data.ajouterEtudiant(étudiant);
								Alert erreur=new Alert(Alert.AlertType.INFORMATION);
								erreur.setContentText("ajout effectué avec succès");
								erreur.setGraphic(null);
								erreur.show();	
								t1.setText("");
								t2.setText("");
								t3.setText("");
								choixFiliere.setValue(null);
							}
							else {
								Alert erreur=new Alert(Alert.AlertType.ERROR);
								erreur.setTitle("ajout impossible");
								erreur.setContentText("l'étudiant existe déjà");
								erreur.setGraphic(null);
								erreur.show();	
							}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						//} catch (IdNullException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
			}
		});
		btn3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Etudiant e;
				try {
					if (t1.getText().equals("")){
						Alert erreur=new Alert(Alert.AlertType.ERROR);
						erreur.setTitle("étudiant introuvable");
						erreur.setContentText("veuillez sasir une valeur pour id_etudiant");
						erreur.setGraphic(null);
						erreur.show();	
					}
					else {
						e = data.rechercherEtudiant(Integer.parseInt(t1.getText()));
						if(e!=null) {
							data.supprimerEtudiant(e);
							Alert erreur=new Alert(Alert.AlertType.INFORMATION);
							erreur.setContentText("supression effectuée avec succès");
							erreur.setGraphic(null);
							erreur.show();	
							t1.setText("");
							t2.setText("");
							t3.setText("");
							choixFiliere.setValue(null);
						}
						else {
							Alert erreur=new Alert(Alert.AlertType.ERROR);
							erreur.setTitle("supression impossible");
							erreur.setContentText("l'étudiant n'existe pas");
							erreur.setGraphic(null);
							erreur.show();	
						}
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
		public void handle(ActionEvent event) /*throws AWTException */{
				try {
					Etudiant e=data.rechercherEtudiant(Integer.parseInt(t1.getText()));
					if (e!=null) {
						t2.setText(e.getNom());
						t3.setText(e.getPrenom());
						int j=0;
						for(int i=0;i<Filieres.size();i++) {
							i=j;
							break;
						}
					    choixFiliere.getSelectionModel().select(3);
					}
					else {
						Alert erreur=new Alert(Alert.AlertType.ERROR);
						erreur.setTitle("aucun résultat");
						erreur.setContentText("cet étudiant n'existe pas");
						erreur.setGraphic(null);
						erreur.show();	
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
			}
			
		});
		stage.setOnCloseRequest(new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent event) {
				event.consume();
				Alert confirmer = new Alert(Alert.AlertType.CONFIRMATION);
				confirmer.setTitle("confirmation");
				confirmer.setContentText("Voulez-vous vraiment quitter");
				confirmer.setHeaderText(null);
				confirmer.getButtonTypes().removeAll(ButtonType.CANCEL,ButtonType.OK);
				ButtonType btnOUI = new ButtonType("Oui");
				ButtonType btnNON = new ButtonType("Non");
				confirmer.getButtonTypes().addAll(btnOUI,btnNON);
				Optional<ButtonType> résultat = confirmer.showAndWait();
				if(résultat.get()==btnOUI)
					System.exit(0);
				
			}
			
		});

		
		stage.show();
		
	}
	public static void main(String[] args){
		launch(args);
	
	}

}

