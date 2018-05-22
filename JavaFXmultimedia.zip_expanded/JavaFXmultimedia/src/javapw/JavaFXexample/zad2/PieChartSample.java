package javapw.JavaFXexample.zad2;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Group;
 
public class PieChartSample extends Application {
 
	 ObservableList<PieChart.Data> pieChartData; 
	// int i = 500;
    public void start(Stage stage) {
    	Button button = new Button();
    	button.setText("Apples Random");
    	
//    	StackPane root = new StackPane();
//    	root.getChildren().add(button);
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	grid.setHgap(5);
    	grid.setVgap(5);
    	grid.setPadding(new	Insets(25, 25, 25, 25));
        //Scene scene = new Scene(new Group());
    	Scene scene = new Scene(grid, 300, 275);
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(600);
 
        pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
        	
        	@Override
        	public void handle(ActionEvent event) {
        		// TODO Auto-generated method stub
        		double i = Math.random()*200;
        		pieChartData.remove(4);
        		pieChartData.add(new PieChart.Data("Apples", i));
        		
        		
        	}
        	
        });
        
//        ((Group) scene.getRoot()).getChildren().add(chart);
//        ((Group) scene.getRoot()).getChildren().add(button);
        grid.add(chart, 0, 0);
        grid.add(button, 0, 1);
        
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}