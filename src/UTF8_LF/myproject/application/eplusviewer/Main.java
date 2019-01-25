package myproject.application.eplusviewer;
	
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import myproject.application.eplusviewer.ApplicationController;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {

			URL fxml = getClass().getResource("layout_eplusviewer.fxml");
			FXMLLoader ldr = new FXMLLoader(fxml, null);
			ApplicationController ac = new ApplicationController(primaryStage);
			ldr.setController(ac);
			Parent root = ldr.load();
			primaryStage.setTitle("E+Viewer ver.2.0.0");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application_eplusviewer.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//ReadMe表示
//			String title					= "ReadMe";
//			String headerText				= "E+Viewer";
//			String contentText				= "";
//			String expandableContentText	= "";
//			String OS_NAME					= System.getProperty("os.name").toLowerCase();
//			
//			try {
//				BufferedReader br	= null;
//				
//				if(OS_NAME.startsWith("windows")){
//					br	= new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("ReadMe_windows.txt")));
//				}else{
//					br	= new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("ReadMe_linux.txt")));
//				}
//				String str	= "";
//				
//				while((str = br.readLine()) != null) {
//					contentText	+= str;
//					contentText	+= "\n";
//				}
//
//				br.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}	
//			
//			try {
//				BufferedReader br	= null;
//				
//				if(OS_NAME.startsWith("windows")){
//					br	= new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Manual_windows.txt")));
//				}else{	
//					br	= new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Manual_linux.txt")));					
//				}
//				String str	= "";
//				
//				while((str = br.readLine()) != null) {
//					expandableContentText	+= str;
//					expandableContentText	+= "\n";
//				}
//
//				br.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//			
//			Alert alert	= new Alert(AlertType.INFORMATION);
//			alert.setTitle(title);
//			alert.setHeaderText(headerText);
//			alert.setContentText(contentText);
//			if(!expandableContentText.isEmpty()) {
//				TextArea textArea	= new TextArea(expandableContentText);
//				textArea.setEditable(false);
//				alert.getDialogPane().setExpandableContent(textArea);
//			}
//
//			alert.setResizable(true);
//			alert.getDialogPane().setPrefSize(600, 700);
//			
//			alert.showAndWait();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
