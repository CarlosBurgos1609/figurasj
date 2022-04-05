/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasj.Panel;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import figurasj.Dibujo;

/**
 *
 * @author Santiago
 */
public class LienzoPanel extends JPanel {

    private Color color;
    private List<Dibujo> dibujos;

    public LienzoPanel(Color color) {
        super();
        this.color = color;
        this.dibujos = new ArrayList<>();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (Dibujo dibujo : dibujos) {
            switch (dibujo.getFigura()) {
                case LINEA:
                    graphics.setColor(dibujo.getColor());
                    graphics.drawLine(dibujo.getX1(), dibujo.getY1(), dibujo.getX2(), dibujo.getY2());
                    break;
                case RECTANGULO:
                    graphics.setColor(dibujo.getColor());
                    if (dibujo.getRelleno()) {
                        graphics.fillRect(dibujo.getX1(), dibujo.getY1(), dibujo.getX2(), dibujo.getY2());
                    } else {
                        graphics.drawRect(dibujo.getX1(), dibujo.getY1(), dibujo.getX2(), dibujo.getY2());
                    }
                    break;
                case ELIPSE:
                    graphics.setColor(dibujo.getColor());
                    if (dibujo.getRelleno()) {
                        graphics.fillOval(dibujo.getX1(), dibujo.getY1(), dibujo.getX2(), dibujo.getY2());
                    } else {
                        graphics.drawOval(dibujo.getX1(), dibujo.getY1(), dibujo.getX2(), dibujo.getY2());
                    }
                    break;
                case TRIANGULO:
                    graphics.setColor(dibujo.getColor());
                    if (dibujo.getRelleno()) {
                        graphics.fillPolygon(
                                new int[] { dibujo.getX1(), dibujo.getX1() + dibujo.getX2(), dibujo.getY1() },
                                new int[] { dibujo.getY1(), dibujo.getY1(), dibujo.getY1() + dibujo.getY2() }, 3);
                    } else {
                        graphics.drawPolygon(
                                new int[] { dibujo.getX1(), dibujo.getX1() + dibujo.getX2(), dibujo.getY1() },
                                new int[] { dibujo.getY1(), dibujo.getY1(), dibujo.getY1() + dibujo.getY2() }, 3);
                    }
                    break;
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.repaint();
    }

    public void addDibujo(Dibujo dibujo) {
        this.dibujos.add(dibujo);
        this.repaint();
    }

    public void limpiar() {
        this.dibujos.clear();
        this.repaint();
    }
}
