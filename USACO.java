import java.util.*;
import java.io.*;

public class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    File f = new File(filename);
    Scanner s = new Scanner(f);
    int r = s.nextInt();
    int c = s.nextInt();
    int e = s.nextInt();
    int n = s.nextInt();
    int[][] field = new int[r][c];
    for (int x = 0; x < r; x++){
      s.nextLine();
      for (int y = 0; y < c; y++){
        field[x][y] = s.nextInt();
      }
    }
  }
  public static void main(String[] args) throws FileNotFoundException{
    bronze("test.txt");
  }
}
