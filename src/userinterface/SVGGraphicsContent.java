package userinterface;

import geometry.IPoint;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import visual.IGraphicContext;
import visual.IWriter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.FileWriter;
import java.io.IOException;

public class SVGGraphicsContent implements IGraphicContext, IWriter {
    SVGGraphics2D graphics2D;

    public SVGGraphicsContent() {
        DOMImplementation domImpl =
                GenericDOMImplementation.getDOMImplementation();

        // Create an instance of org.w3c.dom.Document.
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);

        // Create an instance of the SVG Generator.
        this.graphics2D = new SVGGraphics2D(document);
        graphics2D.setPaint(Color.GREEN);
    }

    @Override
    public void visualizeFirstPoint(IPoint point) {
        graphics2D.draw(new Ellipse2D.Double(point.getX(), point.getY(), point.getX() + 2, point.getY() + 2));
    }

    @Override
    public void visualizeLastPoint(IPoint point) {
        graphics2D.draw(new Line2D.Double(point.getX(), point.getY(), point.getX() - 10, point.getY() - 10));
        graphics2D.draw(new Line2D.Double(point.getX(), point.getY(), point.getX() - 5, point.getY()));
        graphics2D.draw(new Line2D.Double(point.getX(), point.getY(), point.getX(), point.getY() - 5));
    }

    @Override
    public void visualizeSegment(IPoint p1, IPoint p2) {
        graphics2D.draw(new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
    }

    @Override
    public void visualizePoint(IPoint point) {

    }

    @Override
    public void write(FileWriter out) {
        try {
            graphics2D.stream(out, false);
        } catch (IOException e) {

        }
    }
}
