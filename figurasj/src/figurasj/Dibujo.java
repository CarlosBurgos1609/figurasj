/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasj;

import java.awt.Color;

/**
 *
 * @author Santiago
 */
public class Dibujo {

    private int x1, y1, x2, y2;
    private Figura figura;
    private boolean relleno;
    private Color color;

    public Dibujo(int x1, int y1, int x2, int y2, Figura figura, boolean relleno, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.figura = figura;
        this.relleno = relleno;
        this.color = color;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public Figura getFigura() {
        return figura;
    }

    public boolean getRelleno() {
        return relleno;
    }

    public Color getColor() {
        return color;
    }
}
