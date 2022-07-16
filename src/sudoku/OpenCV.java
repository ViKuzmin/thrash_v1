package sudoku;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;

public class OpenCV extends JFrame {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("Version openCV " + Core.VERSION);
    }

    public static void main(String[] args) {

//        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
//        System.out.println("mat = " + mat.dump());

        JFrame window = new JFrame();
        JLabel screen = new JLabel();

        JFrame window2 = new JFrame();
        JLabel screen2 = new JLabel();



        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.setVisible(true);

        Mat img = Imgcodecs.imread("test1.png");
        Mat emptyImg = new Mat(img.size(), img.type());



        MatOfByte matOfByte = new MatOfByte();
        MatOfByte matOfByte2 = new MatOfByte();

        Imgcodecs.imencode(".png", img, matOfByte);

        Imgcodecs.imencode(".png", emptyImg, matOfByte2);

        ImageIcon icon = new ImageIcon(matOfByte.toArray());
        ImageIcon icon2 = new ImageIcon(matOfByte2.toArray());

        screen.setIcon(icon);
        window.getContentPane().add(screen);
        window.pack();

        screen2.setIcon(icon2);
        window2.getContentPane().add(screen2);
        window2.pack();

    }
}
