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
    for (int i = 0; i < n; i++){
      s.nextLine();
      int rs = s.nextInt() - 1;
      int cs = s.nextInt() - 1;
      int ds = s.nextInt();
      int max = field[rs][cs];
      for (int q = 0; q < 3; q++){
        for (int w = 0; w < 3; w++){
          if (field[rs + q][cs + w] > max){
            max = field[rs + q][cs + w];
          }
        }
      }
      for (int p = 0; p < 3; p++){
        for (int o = 0; o < 3; o++){
          if (field[rs + p][cs + o] >= max - ds){
            field[rs + p][cs + o] = max - ds;
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
  public static int silver(String filename) throws FileNotFoundException{
    File f = new File(filename);
    Scanner s = new Scanner(f);
    int r = s.nextInt();
    int c = s.nextInt();
    int time = s.nextInt();
    char[][] pasture = new char[r][c];
    s.nextLine();
    for (int x = 0; x < r; x++){
      String line = s.nextLine();
      for (int y = 0; y < c; y++){
        pasture[x][y] = line.charAt(y);
      }
    }
    int[][] movecount = new int[r][c];
    int[][] toAdd = new int[r][c];
    for (int p = 0; p < r; p++){
      for (int o = 0; o < c; o++){
        movecount[p][o] = 0;
        toAdd[p][o] = 0;
      }
    }
    movecount[s.nextInt() - 1][s.nextInt() - 1] = 1;
    for (int i = 0; i < time; i++){
      for (int z = 0; z < r; z++){
        for (int t = 0; t < c; t++){
          if (movecount[z][t] > 0){
            if (z + 1 < r && pasture[z + 1][t] != '*'){
              toAdd[z + 1][t] += movecount[z][t];
            }
            if (z - 1 >= 0 && pasture[z - 1][t] != '*'){
              toAdd[z - 1][t] += movecount[z][t];
            }
            if (t + 1 < c && pasture[z][t + 1] != '*'){
              toAdd[z][t + 1] += movecount[z][t];
            }
            if (t - 1 >= 0 && pasture[z][t - 1] != '*'){
              toAdd[z][t - 1] += movecount[z][t];
            }
            toAdd[z][t] -= movecount[z][t];
          }
        }
      }
      for (int q = 0; q < r; q++){
        for (int w = 0; w < c; w++){
          movecount[q][w] += toAdd[q][w];
          toAdd[q][w] = 0;
        }
      }
    }
    return movecount[s.nextInt() - 1][s.nextInt() - 1];
  }
  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(bronze("makelake.3.in"));
  }
}
