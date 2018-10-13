/**
 * @TITLE Program5
 * @COURSE CS 1121 Introduction to Programming
 * @AUTHOR ALEX ESCHENAUER AND DEITRICK WILSON
 * @CREATED 12/3/15
 * @DESCRIPTION Make a web browser using javaFX
 */

// IMPORTS
// These are some classes that may be useful for completing the project.
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


//The main class for Program5. Program5 constructs the JavaFX window and handles interactions with the dynamic components contained therein.
public class Program5 extends Application {
	// INSTANCE VARIABLES
	private WebView browser = null;
	private WebEngine webEngine = null;
	private TextField statusbar = null;
	private int count;
	private ArrayList<String> NSA = new ArrayList<String>(); //THIS DEFINITLY DOES NOT TRACK HISTORY. ONLY ON TERRORISTS. IF YOUR NOT A TERRORIST UR FINE I SWEAR
	
	// HELPER METHODS
	//Retrieves the value of a command line argument specified by the index. @param index - position of the argument in the args list. @return The value of the command line argument.
	private String getParameter( int index ) {
		Parameters params = getParameters();
		List<String> parameters = params.getRaw();
		return !parameters.isEmpty() ? parameters.get(0) : "";
	}

	//Creates a WebView which handles mouse and some keyboard events, and manages scrolling automatically, so there's no need to put it into a ScrollPane. The associated WebEngine is created automatically at construction time. @return browser - a WebView container for the WebEngine. 
	private WebView makeHtmlBrowser( ) {
		browser = new WebView();
		webEngine = browser.getEngine();
		return browser;
	}
	
	//Generates the status bar layout and text field. @return statusbarPane - the HBox layout that contains the statusbar.
	private HBox makeStatusBar( ) {
		HBox statusbarPane = new HBox();
		statusbarPane.setPadding(new Insets(5, 4, 5, 4));
		statusbarPane.setSpacing(10);
		statusbarPane.setStyle("-fx-background-color: #336699;");
		statusbar = new TextField("LOOK AT DOCUMENTATION ON HELP PAGE");
		HBox.setHgrow(statusbar, Priority.ALWAYS);
		statusbarPane.getChildren().addAll(statusbar);
		statusbar.setEditable(false);
		return statusbarPane;
	}
	
	private void loadPage(String url) {
        try {
            webEngine.load(url);
        } catch (Exception e) {
            System.out.println("The URL you requested could not be found.");
        }
    }

	// REQUIRED METHODS
	@Override
	public void start(final Stage stage) {
		count = 0;
		//Creates the back button. 
		Button btn1 = new Button("<--");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
            	if(count > 0){
            		webEngine.load(NSA.get(count-1));
            		count--;
            		stage.setTitle(NSA.get(count));
            	}
               
            }
        });
		
		//Creates the forward button.
		Button btn2 = new Button("-->");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event1) {
            	//if(NSA.size() < count){
            		webEngine.load(NSA.get(count+1));
            		count++;
            		stage.setTitle(NSA.get(count));
            	//}
            }
        });
		
		//CREATES REFRESH BUTTON
		Button refresh = new Button("REFRESH");
		refresh.setOnAction(new EventHandler<ActionEvent>() {
			 
            public void handle(ActionEvent event) {
                webEngine.reload();
            }
        });
		
		//Creates the URL box
		final TextField URL = new TextField ("ENTER DESIRED URL");
		 URL.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent event2) {
	                loadPage(event2.toString());
	            }
		 });
		 
		 //THIS MAKES THE GO BUTTON
		 Button go = new Button("GO");
			go.setOnAction(new EventHandler<ActionEvent>() {
	 
	            public void handle(ActionEvent event1) {
	            	NSA.add("http://" + URL.getText());
	                webEngine.load("http://" + URL.getText());
	                count++;
	                stage.setTitle(NSA.get(count));
	            }
	        });
		
		//THIS MAKES THE HELP BUTTON
		Button HELP = new Button("HELP");
		HELP.setOnAction(new EventHandler<ActionEvent>() {
				 
	            public void handle(ActionEvent event) {
	            	NSA.add("https://docs.google.com/a/mtu.edu/document/d/1AldvrZOPq18jyfHn1jdd9Z4f6VtwS6in85ShDIngBeY/edit?usp=sharing");
	    			webEngine.load("https://docs.google.com/a/mtu.edu/document/d/1AldvrZOPq18jyfHn1jdd9Z4f6VtwS6in85ShDIngBeY/edit?usp=sharing");
	    			stage.setTitle("https://docs.google.com/a/mtu.edu/document/d/1AldvrZOPq18jyfHn1jdd9Z4f6VtwS6in85ShDIngBeY/edit?usp=sharing");
	            }
	        });
		
		BorderPane border = new BorderPane();
		
		HBox hb = new HBox(btn1,btn2,refresh, URL, go, HELP);
		hb.setSpacing(10);
		
		//MAKES THE BROWSER BOX AND LOADS FIRST PAGE
		String loadDetermine = getParameter(0);
		HBox web = new HBox( makeHtmlBrowser());
		if(loadDetermine != ""){
			NSA.add(getParameter(0));
			webEngine.load(getParameter(0));
			stage.setTitle(getParameter(0));
		}
		else{
			NSA.add("https://docs.google.com/a/mtu.edu/document/d/1AldvrZOPq18jyfHn1jdd9Z4f6VtwS6in85ShDIngBeY/edit?usp=sharing");
			webEngine.load("https://docs.google.com/a/mtu.edu/document/d/1AldvrZOPq18jyfHn1jdd9Z4f6VtwS6in85ShDIngBeY/edit?usp=sharing");
			stage.setTitle("https://docs.google.com/a/mtu.edu/document/d/1AldvrZOPq18jyfHn1jdd9Z4f6VtwS6in85ShDIngBeY/edit?usp=sharing");
		}
		stage.setTitle(NSA.get(count));
		
		//Sets the locations of the boxes in the window.
		border.setCenter(web);
		border.setTop(hb);
		border.setBottom(makeStatusBar());
		
		//MAKES THE SCENE
	    Scene scene1 = new Scene(border, 800, 1000);
	    stage.setScene(scene1);
	    stage.show();
	    
	    //THIS CHANGES THE STATUS BAR AND SAVES THE PAGES THAT IT LOADS IN AN ARRAY CALLED NSA
	    webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>(){
	    	public void changed(@SuppressWarnings("rawtypes") ObservableValue ov, State oldState, State newState){
	    		if(newState==State.SUCCEEDED){
	    			NSA.add(webEngine.getLocation());
	    			count++;
	    			stage.setTitle(webEngine.getTitle());
	    			statusbar.setText(webEngine.getLocation());
	    		}
	    	}
	    });
	    
	    
	}
	public static void main(String[] args) {
		launch(args);
	}
}