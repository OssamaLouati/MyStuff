package evenement;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExempleRedirection extends Application {

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		// TODO Auto-generated method stub
		StackPane racine = new StackPane();
		Button bouton = new Button("Ouvrir nouvelle fenetre");
		bouton.setPrefSize(150, 20);
		racine.getChildren().add(bouton);
		Scene scene= new Scene(racine,300,200);
		fenetrePrincipale.setScene(scene);
		fenetrePrincipale.setTitle("Fenetre principale");

		fenetrePrincipale.show();
		
		bouton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				Stage nouvelleFenetre = new Stage();
				nouvelleFenetre.setTitle("Nouvelle fenetre");
				nouvelleFenetre.initModality(Modality.WINDOW_MODAL);
				nouvelleFenetre.initOwner(fenetrePrincipale);
				StackPane racine = new StackPane();
				Label l1 = new Label("Nouvelle fenetre");
				racine.getChildren().add(l1);
				nouvelleFenetre.setScene(new Scene(racine,200,100));
				nouvelleFenetre.show();
				
				
			}
		});
	}
	
	public static void main(String[] ar) {
		ExempleRedirection.launch(ar);
	}

}
