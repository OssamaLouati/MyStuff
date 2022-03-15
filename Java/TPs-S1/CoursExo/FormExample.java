package Coursexo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FormExample extends Application{
	 

	@Override
	public void start(Stage primaryStage) throws Exception {
		 primaryStage.setTitle("Formulaire d'authentification");
		 
		 GridPane grid = new GridPane();
		 grid.setAlignment(Pos.CENTER);
		 grid.setHgap(10);
		 grid.setVgap(10);
		 grid.setPadding(new Insets(25, 25, 25, 25));

		 Scene scene = new Scene(grid, 300, 275);
		 primaryStage.setScene(scene);
		 
		 
		 Text titre = new Text("Bienvenue");
		 titre.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		 grid.add(titre, 0, 0, 2, 1);


		 Label nomUtilisateur = new Label("Utilisateur :");
		 grid.add(nomUtilisateur, 0, 1);

		 TextField utilisateurTf = new TextField();
		 grid.add(utilisateurTf, 1, 1);

		 Label mdp = new Label("Mot de passe :");
		 grid.add(mdp, 0, 2);

		 PasswordField mdpPf = new PasswordField();
		 grid.add(mdpPf, 1, 2);
		 
		 Button btn = new Button("Se connecter");
		 btn.setFont(Font.font("Tahoma",FontWeight.BOLD,14));
		 HBox hbBtn = new HBox(10);
		 hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		 hbBtn.getChildren().add(btn);
		 grid.add(hbBtn, 1, 4);

		 final Text actionTxt = new Text();
	     grid.add(actionTxt, 1, 6);
	        
	     btn.setOnAction(new EventHandler<ActionEvent>() {
	    	    @Override
	    	    public void handle(ActionEvent e) {
	    	        actionTxt.setFill(Color.FIREBRICK);
	    	        actionTxt.setText("Connexion "+" "+utilisateurTf.getText());
	    	    }
	    	});
	     
	     
	     primaryStage.show();
		
	}
	public static void main(String[] args) {
        FormExample.launch(args);
    }
}
