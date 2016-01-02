import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jesus Zarate on 12/30/15.
 *
 * POND SIZES: You have an integer matrix representing a plot of land, where the value at that
 * location represents the height above sea level. A value of zero indicates water. A pond is
 * a region of water connected vertically, horizontally, or diagonally. The size of the pond
 * is the total number of connected water cells. Write a method to compute the sizes of all
 * ponds in the matrix.
 *
 * Example
 * input:
 *  0 2 1 0
 *  0 1 0 1
 *  1 1 0 1
 *  0 1 0 1
 *
 *  Output: 2, 4, 1 (in any order)
 *
 */
public class FindPonds
{
    public static void main(String[] args){
       int[][] land =  new int[][]{
               {0, 2, 1, 0,},
               {0, 1, 0, 1},
               {1, 1, 0, 1},
               {0, 1, 0, 1}};

        for(int i : findPonds(land)){
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> findPonds(int[][] Land)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int rowLen = Land.length;
        int colLen = Land[0].length;

        boolean[][] visited = new boolean[rowLen][colLen];
        //Arrays.fill(visited[0], Boolean.FALSE);
        //Arrays.fill(visited[1], Boolean.FALSE);

        for(int row = 0; row < rowLen; row++)
        {
            for(int col = 0; col < colLen; col++)
            {
                if(Land[row][col] != 0 || visited[row][col])
                {
                    continue;
                }

                result.add(getPondSize(row, col, Land, visited));
            }
        }

        return result;
    }

    public static int getPondSize(int currRow, int currCol, int[][] Land, boolean[][] visited)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(currRow, currCol)); // Check if offer adds to the Q
        visited[currRow][currCol] = true;

        int totSize = 0;
        Node curr;
        while (!q.isEmpty())
        {
            curr = q.poll();

            if(Land[curr.row][curr.col] == 0){
                totSize++;
            }

            addNeighbors(currRow, currCol, q, Land, visited);
        }
        return totSize;
    }

    public static void addNeighbors(int currRow, int currCol, Queue<Node> q, int[][] Land, boolean[][] visited)
    {
        int rowLen = Land.length;
        int colLen = Land[0].length;

        for(int i = (currRow - 1); i <= (currRow + 1); i++)
        {
            for(int j = (currCol - 1); j <= (currCol + 1); j++)
            {
                if((i >= 0 && j >= 0) &&
                        (i < rowLen && j < colLen)){
                    if(!visited[i][j] && Land[i][j] == 0)
                    {
                        q.add(new Node(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }
    }

    static class Node{
        int row;
        int col;

        public Node(int _row, int _col){
            row = _row;
            col = _col;
        }
    }
}



