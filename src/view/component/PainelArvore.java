
package view.component;

import model.Node;
import javax.swing.*;
import java.awt.*;

public class PainelArvore extends JPanel {
    private Node raiz;
    private static final int RAIO_NO = 22;
    private static final int ESPACO_VERTICAL = 60;
    private static final Color COR_FUNDO = new Color(43, 43, 43); // #2B2B2B
    private static final Color COR_LINHA = new Color(120, 120, 120);
    private static final Color COR_NO = new Color(75, 75, 75);
    private static final Color COR_BORDA_NO = new Color(150, 150, 150);
    private static final Color COR_TEXTO = Color.WHITE;
    private static final Font FONTE_NO = new Font("Segoe UI", Font.BOLD, 14);
    public PainelArvore() {
        setBackground(COR_FUNDO);
    }
    public void setRaiz(Node raiz) {
        this.raiz = raiz;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        if (raiz != null) {
            desenharArvore(g2d, raiz, getWidth() / 2, 50, getWidth() / 4);
        }
    }
    private void desenharArvore(Graphics2D g, Node no, int x, int y, int espacoHorizontal) {
        if (no == null) {
            return;
        }
        g.setColor(COR_NO);
        g.fillOval(x - RAIO_NO, y - RAIO_NO, 2 * RAIO_NO, 2 * RAIO_NO);
        g.setColor(COR_BORDA_NO);
        g.drawOval(x - RAIO_NO, y - RAIO_NO, 2 * RAIO_NO, 2 * RAIO_NO);
        g.setColor(COR_TEXTO);
        g.setFont(FONTE_NO);
        String texto = String.valueOf(no.getData());
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(texto);
        g.drawString(texto, x - textWidth / 2, y + fm.getAscent() / 2);
        g.setColor(COR_LINHA);
        g.setStroke(new BasicStroke(1.5f));
        if (no.getLeft() != null) {
            int xFilho = x - espacoHorizontal;
            int yFilho = y + ESPACO_VERTICAL;
            g.drawLine(x, y + RAIO_NO, xFilho, yFilho - RAIO_NO);
            desenharArvore(g, no.getLeft(), xFilho, yFilho, Math.max(espacoHorizontal / 2, 30));
        }
        if (no.getRight() != null) {
            int xFilho = x + espacoHorizontal;
            int yFilho = y + ESPACO_VERTICAL;
            g.drawLine(x, y + RAIO_NO, xFilho, yFilho - RAIO_NO);
            desenharArvore(g, no.getRight(), xFilho, yFilho, Math.max(espacoHorizontal / 2, 30));
        }
    }
}
