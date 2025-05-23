
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PercolationGamePanel extends JPanel implements KeyListener {
    private final int gridSize = 10;
    private final int cellSize = 40;
    private final int scoreBarHeight = 40;

    private enum CellState { EMPTY, BLOCK, CONNECTED }
    private final CellState[][] grid = new CellState[gridSize][gridSize];

    private final PercolationUF uf;
    private final int virtualTop;
    private final int virtualBottom;

    private int cursorRow = 0;
    private int cursorCol = 0;
    private int score = 0;

    public PercolationGamePanel() {
        setPreferredSize(new Dimension(gridSize * cellSize, gridSize * cellSize + scoreBarHeight));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this);

        uf = new PercolationUF(gridSize * gridSize + 2);
        virtualTop = gridSize * gridSize;
        virtualBottom = gridSize * gridSize + 1;

        resetGame();
    }

    private void resetGame() {
        Random rand = new Random();
        for (int r = 0; r < gridSize; r++) {
            for (int c = 0; c < gridSize; c++) {
                grid[r][c] = rand.nextDouble() < 0.3 ? CellState.BLOCK : CellState.EMPTY;
            }
        }

        for (int i = 0; i < gridSize * gridSize + 2; i++) {
            uf.union(i, i);
        }

        cursorRow = 0;
        cursorCol = 0;
        repaint();
    }

    private int xyTo1D(int r, int c) {
        return r * gridSize + c;
    }

    private void connectCell(int r, int c) {
        if (grid[r][c] != CellState.BLOCK) return;

        grid[r][c] = CellState.CONNECTED;
        int index = xyTo1D(r, c);

        if (r == 0) uf.union(index, virtualTop);
        if (r == gridSize - 1) uf.union(index, virtualBottom);

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < gridSize && nc >= 0 && nc < gridSize &&
                grid[nr][nc] == CellState.CONNECTED) {
                uf.union(index, xyTo1D(nr, nc));
            }
        }

        if (uf.connected(virtualTop, virtualBottom)) {
            score++;
            JOptionPane.showMessageDialog(this, "Percolation! Score: " + score);
            resetGame();
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw score
        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.BOLD, 18));
        g.drawString("Score: " + score, 10, 25);

        // Draw grid
        for (int r = 0; r < gridSize; r++) {
            for (int c = 0; c < gridSize; c++) {
                int x = c * cellSize;
                int y = r * cellSize + scoreBarHeight;

                switch (grid[r][c]) {
                    case EMPTY -> g.setColor(Color.LIGHT_GRAY);
                    case BLOCK -> g.setColor(Color.DARK_GRAY);
                    case CONNECTED -> g.setColor(Color.BLUE);
                }

                g.fillRect(x, y, cellSize, cellSize);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellSize, cellSize);
            }
        }

        // Draw cursor
        g.setColor(Color.RED);
        g.drawRect(cursorCol * cellSize, cursorRow * cellSize + scoreBarHeight, cellSize, cellSize);
    }

    // Key control logic
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> cursorRow = Math.max(0, cursorRow - 1);
            case KeyEvent.VK_DOWN -> cursorRow = Math.min(gridSize - 1, cursorRow + 1);
            case KeyEvent.VK_LEFT -> cursorCol = Math.max(0, cursorCol - 1);
            case KeyEvent.VK_RIGHT -> cursorCol = Math.min(gridSize - 1, cursorCol + 1);
            case KeyEvent.VK_SPACE -> connectCell(cursorRow, cursorCol);
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
