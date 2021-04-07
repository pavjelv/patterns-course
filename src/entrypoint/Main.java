package entrypoint;

import geometry.Bezier;
import geometry.Line;
import geometry.Point;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import userinterface.FormGraphicContext;
import userinterface.VisualBezier;
import userinterface.VisualLine;
import visual.IGraphicContext;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        IGraphicContext formGraphicContext = new FormGraphicContext(gc);
        Line line = new Line(new Point(0.0, 0.0), new Point(100.0, 100.0));
        new VisualLine(line).draw(formGraphicContext);
        Bezier bezier = new Bezier(new Point(0.0, 0.0), new Point(0.0, 40.0), new Point(40.0, 10.0), new Point(100.0, 100.0));
        new VisualBezier(bezier).draw(formGraphicContext);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
