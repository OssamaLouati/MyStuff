

import intro.PremierExemple;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ExempleRepartition extends Application{
	
	@Override
	public void start(Stage fenetre) throws Exception {
		VBox box = new VBox();
		//box.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
		box.setPadding( new Insets(20,50,20,50));
		Button btn = new Button("OK");
		btn.setMinSize(30, 80);
		TextField tf = new TextField();
		Label l1 = new Label();
		box.getChildren().addAll(tf,btn,l1);
		Scene scene1 = new Scene(box,200,200);
		fenetre.setScene(scene1);
		fenetre.setTitle("Gestion Evènements");
		fenetre.show();	
		
		
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent evt) {
				System.out.println("Bouton");
				System.out.println("Source "+evt.getSource());
				System.out.println("Target "+evt.getTarget());
				l1.setText(tf.getText());
				tf.setText("");
				System.out.println("-------------");
			}
		});
		
		l1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent evt) {
				System.out.println("label");
				System.out.println("Source "+evt.getSource());
				System.out.println("Target "+evt.getTarget());
				//evt.consume();
				System.out.println("-------------");
			}
		});
		
		box.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent evt) {
				System.out.println("box");
				System.out.println("Source "+evt.getSource());
				System.out.println("Target "+evt.getTarget());
				System.out.println("-------------");
			}
		});
	}
	
	
	public static void main(String[] args) {
		ExempleRepartition.launch(args);
	}
	
}
