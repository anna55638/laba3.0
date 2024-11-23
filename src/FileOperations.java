import java.io.*;

public class FileOperations {
    // Сохранение строки в файл
    public void saveStringToFile(String content, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    // Загрузка строки из файла
    public String loadStringFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim();
    }

    // Сохранение матрицы в файл
    public void saveMatrixToFile(String[][] matrix, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Сначала записываем размеры матрицы
            writer.write(matrix.length + "," + matrix[0].length + "\n");

            // Записываем элементы матрицы
            for (String[] row : matrix) {
                for (int j = 0; j < row.length; j++) {
                    writer.write(row[j]);
                    if (j < row.length - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }
        }
    }

    // Загрузка матрицы из файла
    public String[][] loadMatrixFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Читаем размеры матрицы
            String[] dimensions = reader.readLine().split(",");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);

            String[][] matrix = new String[rows][cols];

            // Читаем элементы матрицы
            for (int i = 0; i < rows; i++) {
                String[] values = reader.readLine().split(",");
                System.arraycopy(values, 0, matrix[i], 0, cols);
            }

            return matrix;
        }
    }
}