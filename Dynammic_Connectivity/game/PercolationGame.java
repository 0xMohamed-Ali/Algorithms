import javax.swing.*;

public class PercolationGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Percolation Puzzle");
            PercolationGamePanel gamePanel = new PercolationGamePanel();
            frame.setContentPane(gamePanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            gamePanel.requestFocusInWindow(); // capture keyboard input
        });
    }
}
