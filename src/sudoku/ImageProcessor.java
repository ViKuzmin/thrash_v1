package sudoku;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;

public class ImageProcessor extends JFrame {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("Version openCV " + Core.VERSION);
    }

    public static void main(String[] args) {

        JFrame window = new JFrame();
        JLabel screen = new JLabel();

        JFrame window2 = new JFrame();
        JLabel screen2 = new JLabel();


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.setVisible(true);

//        Import file
        Mat img = Imgcodecs.imread("D:\\JAVA_PROJ\\Sobes\\sourceimg\\sudoku3PVP.jpg").colRange(48, 670).rowRange(220, 840);

        Mat imgPVE = Imgcodecs.imread("D:\\JAVA_PROJ\\Sobes\\sourceimg\\sudoku3PVP.jpg").colRange(28, 690).rowRange(155, 820);
        Mat imgPVP = Imgcodecs.imread("D:\\JAVA_PROJ\\Sobes\\sourceimg\\sudoku3PVP.jpg").colRange(48, 670).rowRange(220, 840);

        Mat emptyImg = new Mat(img.size(), img.type());
        Mat emptyImgPVP = new Mat(imgPVP.size(), imgPVP.type());


        Mat kernel = new Mat(2, 2, CvType.CV_8UC1, new Scalar(1.0));

        Imgproc.cvtColor(img, emptyImg, Imgproc.COLOR_BGR2GRAY);
//        Imgproc.erode(emptyImg, emptyImg, kernel);
        Imgproc.threshold(emptyImg, emptyImg, 200, 255, Imgproc.THRESH_BINARY);

        String flag = "PVP";
        int x = 1;
        int y = 1;

        if (flag.equals("PVE")) {
            for (int i = 2; i < 640; i += 75) {
                for (int j = 2; j < 640; j += 75) {
                    Mat copyEmpty = emptyImg.clone();
                    Imgcodecs.imwrite(String.format("D:\\JAVA_PROJ\\Sobes\\samples\\test%s%s.png", x, y),
                            copyEmpty.rowRange(i + 3, i + 58).colRange(j + 2, j + 58));
                    y++;
                }
                y = 1;
                x++;
            }
        } else if (flag.equals("PVP")) {

            for (int i = 4; i < 580; i += 69) {
                for (int j = 4; j < 580; j += 69) {
                    Mat copyEmpty = emptyImg.clone();
//                    Point start = new Point(i + 1, j + 1);
//                    Point end = new Point(i + 58, j + 58);
//                    Imgproc.rectangle(emptyImg, start, end, new Scalar(0, 255, 0));
                    Imgcodecs.imwrite(String.format("D:\\JAVA_PROJ\\Sobes\\samples\\test%s%s.png", x, y),
                            copyEmpty.rowRange(i + 1, i + 58).colRange(j + 1, j + 58)
                    );
                    y++;
                }
                y = 1;
                x++;
            }
        }


//      Export file
        Imgcodecs.imwrite("D:\\JAVA_PROJ\\Sobes\\goalimg\\test2.png", emptyImgPVP);
//        Imgproc.Canny(img, emptyImg, 10, 10);


        MatOfByte matOfByte = new MatOfByte();
        MatOfByte matOfByte2 = new MatOfByte();
        System.out.println(matOfByte2.toString());


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
