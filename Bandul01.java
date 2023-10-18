import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bandul01 extends JPanel implements ActionListener {
    private double angle = 0; // Sudut awal bandul
    private double angularVelocity = 0.1; // Kecepatan sudut
    private int length = 300; // Panjang tali bandul

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = getWidth() / 2;
        int y = getHeight() / 2;

        // Mengatur transformasi rotasi
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.green);
        g2d.translate(x, y); // Memindahkan pusat rotasi ke titik tengah layar
        g2d.rotate(angle); // Rotasi sudut

        // Menggambar bandul
        g2d.drawLine(0, 0, 0, length); // Gambar tali bandul
        g2d.drawOval(-21, length - 21, 42, 42);
        g2d.setColor(Color.red);
        g2d.fillOval(-20, length - 20, 40, 40); // Gambar bola di ujung bandul
        g2d.setColor(Color.blue);
        g2d.fillOval(-10, -10, 20, 20);

        // Mengembalikan transformasi ke kondisi semula
        g2d.rotate(-angle);
        g2d.translate(-x, -y);
    }

    public void actionPerformed(ActionEvent e) {
        // Mengupdate sudut bandul untuk animasi
        // if (angle >= 1 || angle <= -1)
        // angularVelocity *= -1;
        angle += angularVelocity;

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animasi Bandul");
        Bandul01 bandul = new Bandul01();
        frame.add(bandul);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Timer timer = new Timer(20, bandul); // Timer untuk mengupdate animasi setiap 20 milidetik
        timer.start();
    }
}