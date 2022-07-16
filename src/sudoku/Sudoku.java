package sudoku;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.*;
import java.util.Arrays;

public class Sudoku {

    public static void main(String[] args) {

        while (true) {

//            String filePath = "D:\\JAVA_PROJ\\Sobes\\sourceimg\\pvp\\sudoku6.jpg";
            String pathImg = "D:\\JAVA_PROJ\\Sobes\\samples\\pvp";

//        String filePath = "D:\\JAVA_PROJ\\Sobes\\sourceimg\\pve\\sudoku5.jpg";
//        String pathImg = "D:\\JAVA_PROJ\\Sobes\\samples\\pve";

//            ImageSlicer.handleImage(filePath, pathImg, ImageSlicer.PVP);

            int[][] array = getArrayFromImage(pathImg);

            System.out.println(Arrays.deepToString(array));

            System.out.println(solve(array));
        }


    }

    public static void writeFile(String string, String fileName) {

        try (FileWriter writer = new FileWriter(String.format("%s.txt", fileName), false)) {
            String formattedString = string.replaceAll("[^\\n\\d]", "");
            writer.write(formattedString);

            writer.flush();
            System.out.println("file " + fileName + " is written...");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int[][] getArrayFromImage(String directoryWithSamples) {

        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("ara");

        String path = "D:\\JavaLibrary\\tessdata-main";
        tesseract.setDatapath(path);

        int[][] array = new int[9][9];
        StringBuilder strb = new StringBuilder("");

        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    strb.setLength(0);
                    strb.append(tesseract.doOCR(new File(String
                            .format("%s\\test%s%s.png", directoryWithSamples, i + 1, j + 1))));

                    if(strb.toString().equals("")) {
                        strb.setLength(0);
                        strb.append("0");
                    } else if (strb.toString().contains("?")) {
                        strb.setLength(0);
                        strb.append("2");
                    } else if (strb.toString().contains("{")) {
                        strb.setLength(0);
                        strb.append("7");
                    } else if (strb.toString().contains("V")) {
                        strb.setLength(0);
                        strb.append("7");
                    } else if (strb.toString().contains("g")) {
                        strb.setLength(0);
                        strb.append("9");
                    } else if (strb.toString().contains("o")) {
                        strb.setLength(0);
                        strb.append("5");
                    }

                    strb.setLength(1);

                    array[i][j] = Integer.parseInt(strb.toString());

//                    System.out.println(Arrays.deepToString(array));
                }
            }
        } catch (TesseractException e) {
            e.printStackTrace();
        }

        return array;
    }

    public static int[][] getArrayFromFile(File file) {

        int[][] array = new int[9][9];

        try {

            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();

            int counter = 0;

            while (line != null) {
                System.out.println(line);

                char[] chars = line.toCharArray();

                for (int i = 0; i < array.length; i++) {
                    array[counter][i] = Integer.parseInt(Character.toString(chars[i]));
                }

                counter++;
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }

    public static boolean solve(int[][] sudoku) {
        int i = 0, j = 0;
        boolean found = false;
        // Find an empty cell

        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        // No empty cell found, return true
        if (i == 9 && j == 9) {
            return true;
        }
        // One by one try all the values in the current cell
        for (int n = 1; n <= 9; n++) {
            // check if it is valid to assign value n to current cell
            if (isSafe(i, j, n, sudoku)) {
                sudoku[i][j] = n;
                // Recursively solve the sudoku
                if (solve(sudoku)) {

                    System.out.println(Arrays.deepToString(sudoku));
                    return true;
                }
                // back track if the recursion returns false
                sudoku[i][j] = 0;
            }
        }
        // Return false if no value fits
        return false;
    }

    public static boolean isSafe(int i, int j, int n, int[][] sudoku) {
        // Check in current row and column
        for (int x = 0; x < 9; x++) {
            // Row
            if (sudoku[i][x] == n) {
                return false;
            }
            // Column
            if (sudoku[x][j] == n) {
                return false;
            }
        }

        // Calculate the starting index of row and column of current 3x3 sub box
        int rs = i - (i % 3);
        int cs = j - (j % 3);
        // Check in the current sub box
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (sudoku[x + rs][y + cs] == n) {
                    return false;
                }
            }
        }
        // Return true
        return true;
    }
}
