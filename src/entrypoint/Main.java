package entrypoint;

import com.sun.org.apache.xpath.internal.operations.Or;
import geometry.*;
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
import userinterface.*;
import visual.IGraphicContext;
import visual.VisualCurve;

import java.io.*;

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
        SVGGraphicsContent svgGraphicContent = new SVGGraphicsContent();

        Bezier bezier = new Bezier(
                new Point(10.0, 10.0),
                new Point(50.0, 200.0),
                new Point(150.0, 20.0),
                new Point(200.0, 100.0));
        VisualCurve bezierFragment = new VisualBezier(new Fragment(bezier, 0.5, 1), 7);
        VisualCurve bezierMoved = new VisualBezier(new MoveTo(bezier, new Point(0.0, 0.0)), 7);
        VisualCurve bezierCurve = new VisualBezier(bezier, 7);

        Button button = new Button("Generate");
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                bezierCurve.draw(graphicContext);
                bezierMoved.draw(graphicContext2);
            }
        };
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        Button saveToSVG = new Button("Save to SVG");
        saveToSVG.setDisable(true);
        EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    FileWriter myWriter = new FileWriter("D:/filename.svg");
                    bezierCurve.draw(svgGraphicContent);
                    svgGraphicContent.write(myWriter);
                    myWriter.close();
                } catch (IOException ex) {}
            }
        };
        saveToSVG.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler1);

//        Button saveToSVG2 = new Button("Save to SVG 2");
//        saveToSVG2.setDisable(true);
//        EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent e) {
//                graphicContext2.save(bezierCurve);
//            }
//        };
//        saveToSVG2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);

        GridPane pane = new GridPane();

        pane.add(getSeparator(), 0, 0);
        pane.add(canvas, 1, 0);
        pane.add(getSeparator(), 2, 0);
        pane.add(canvas2, 3, 0);
        pane.add(getSeparator(), 4, 0);

        pane.add(saveToSVG, 1, 1);
//        pane.add(saveToSVG2, 3, 1);

        pane.add(getHorizontalSeparator(), 1, 2);
        pane.add(getHorizontalSeparator(), 3, 2);

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

    private Separator getHorizontalSeparator() {
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
