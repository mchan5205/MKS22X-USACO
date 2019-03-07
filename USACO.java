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
    }/*
    File b = new File(filename);
    Scanner g = new Scanner(b);
    */
    for (int i = 0; i < n; i++){
      s.nextLine();
      int rs = s.nextInt() - 1;
      int cs = s.nextInt() - 1;
      int ds = s.nextInt();
      int max = field[rs][cs];
      for (int q = rs; q < 3; q ++){
        for (int w = cs; w < 3; w++){
          if (field[q][w] > max){
            max = field[q][w];
          }
        }
      }
      for (int p = 0; p < 3; p++){
        for (int o = 0; o < 3; o++){
          if (field[p][o] > max - ds){
            field[p][o] = max - ds;
          }
        }
      }
    }
    int level = 0;
    for (int t = 0; t < field.length; t++){
      for (int h = 0; h < field[t].length; h++){
        if (field[t][h] < e){
          level += (e - field[t][h]) * 72 * 72;
        }
      }
    }
    return level;
  }
  public static int silver(String filename){
    
  }
  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(bronze("test.txt"));
  }
}
