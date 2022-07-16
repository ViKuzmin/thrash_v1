package sudoku;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageSlicer {

    static final String
            PVE = "PVE",
            PVP = "PVP";

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("Version openCV " + Core.VERSION);
    }

//    private String filePath = "D:\\JAVA_PROJ\\Sobes\\sourceimg\\sudoku3PVP.jpg";
//    private String path = "D:\\JAVA_PROJ\\Sobes\\samples";

    public static void handleImage(String filePath, String distDirectory, String mode) {

        int x = 1;
        int y = 1;

        if (mode.equals("PVE")) {

            Mat img = Imgcodecs.imread(filePath).colRange(28, 690).rowRange(155, 820);;
            Mat emptyImg = new Mat(img.size(), img.type());

            Imgproc.cvtColor(img, emptyImg, Imgproc.COLOR_BGR2GRAY);
            Imgproc.threshold(emptyImg, emptyImg, 200, 255, Imgproc.THRESH_BINARY);

            for (int i = 2; i < 640; i += 75) {
                for (int j = 2; j < 640; j += 75) {
                    Mat copyEmpty = emptyImg.clone();
                    Imgcodecs.imwrite(String.format("%s\\test%s%s.png", distDirectory, x, y),
                            copyEmpty.rowRange(i + 3, i + 58).colRange(j + 2, j + 58));
                    y++;
                }
                y = 1;
                x++;
            }

        } else if (mode.equals("PVP")) {

            Mat img = Imgcodecs.imread(filePath).colRange(48, 670).rowRange(220, 840);
            Mat emptyImg = new Mat(img.size(), img.type());

            Imgproc.cvtColor(img, emptyImg, Imgproc.COLOR_BGR2GRAY);
            Imgproc.threshold(emptyImg, emptyImg, 200, 255, Imgproc.THRESH_BINARY);

            for (int i = 4; i < 580; i += 69) {
                for (int j = 4; j < 580; j += 69) {
                    Mat copyEmpty = emptyImg.clone();
                    Imgcodecs.imwrite(String.format("%s\\test%s%s.png", distDirectory, x, y),
                            copyEmpty.rowRange(i + 1, i + 58).colRange(j + 1, j + 58)
                    );
                    y++;
                }
                y = 1;
                x++;
            }
        }

    }
}
