package entrypoint;

import com.sun.org.apache.xpath.internal.operations.Or;
import geometry.Bezier;
import geometry.Line;
import geometry.Point;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import userinterface.FormGraphicContext;
import userinterface.FormGraphicContext2;
import userinterface.VisualBezier;
import userinterface.VisualLine;
import visual.IGraphicContext;
import visual.VisualCurve;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();

        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Canvas canvas2 = new Canvas(400, 400);
        GraphicsContext gc2 = canvas2.getGraphicsContext2D();

        IGraphicContext graphicContext = new FormGraphicContext(gc);
        IGraphicContext graphicContext2 = new FormGraphicContext2(gc2);

        Bezier bezier = new Bezier(
                new Point(10.0, 10.0),
                new Point(50.0, 200.0),
                new Point(150.0, 20.0),
                new Point(200.0, 100.0));
        VisualCurve bezierCurve = new VisualBezier(bezier, 7);

        Button button = new Button("Generate");
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                bezierCurve.draw(graphicContext);
                bezierCurve.draw(graphicContext2);
            }
        };
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        Button saveToSVG = new Button("Save to SVG");
        saveToSVG.setDisable(true);
        EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                graphicContext.save(bezierCurve);
            }
        };
        saveToSVG.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler1);

        Button saveToSVG2 = new Button("Save to SVG 2");
        saveToSVG2.setDisable(true);
        EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                graphicContext2.save(bezierCurve);
            }
        };
        saveToSVG2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);

        GridPane pane = new GridPane();

        pane.add(getSeparator(), 0, 0);
        pane.add(canvas, 1, 0);
        pane.add(getSeparator(), 2, 0);
        pane.add(canvas2, 3, 0);
        pane.add(getSeparator(), 4, 0);

        pane.add(saveToSVG, 1, 1);
        pane.add(saveToSVG2, 3, 1);

        pane.add(getHorisontalSeparator(), 1, 2);
        pane.add(getHorisontalSeparator(), 3, 2);

        pane.add(button, 2, 3);

        root.getChildren().add(pane);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private Separator getSeparator() {
        Separator result = new Separator(Orientation.VERTICAL);
        result.setMinWidth(30);
        return result;
    }

    private Separator getHorisontalSeparator() {
        Separator result = new Separator();
        result.setMinHeight(20);
        return result;
    }

    private void drawShapes(GraphicsContext gc) {
        IGraphicContext formGraphicContext = new FormGraphicContext(gc);

        Line line = new Line(new Point(0.0, 0.0), new Point(100.0, 100.0));
        new VisualLine(line, 20).draw(formGraphicContext);

        Bezier bezier = new Bezier(new Point(10.0, 10.0), new Point(50.0, 200.0), new Point(150.0, 20.0), new Point(200.0, 100.0));
        VisualCurve bezierCurve = new VisualBezier(bezier, 7);
        bezierCurve.draw(formGraphicContext);
        bezierCurve.draw(new FormGraphicContext2(gc));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
