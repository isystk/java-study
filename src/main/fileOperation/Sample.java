package fileOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ファイル操作
 */
public class Sample {
    public static void main(String[] args) {

        try {
            Path sourceFile = Paths.get("src/fileOperation/input.csv");
            Path outputDir = Paths.get("src/fileOperation/optput");
            Path copyFile = Paths.get(String.join(File.separator, outputDir.toString(), "copy.csv"));

            if (Files.deleteIfExists(copyFile)) {
                System.out.println("コピー先のファイルを削除しました。:" + copyFile.getFileName());
            }
            if (Files.deleteIfExists(outputDir)) {
                System.out.println("コピー先のディレクトリを削除しました。:"+outputDir.getFileName());
            }

            // 出力先のディレクトリを作成
            Files.createDirectory(outputDir);

            // ファイルのコピー
            Files.copy(sourceFile, copyFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
