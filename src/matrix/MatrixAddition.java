package matrix;

public class MatrixAddition {
    public static void main(String[] args) {

        int[][] firstMatrix = new int[][] {{1,2,3,4},{5,6,7,8}};
        int[][] secondMatrix = new int[][] {{11,12,13,14},{15,16,17,18}};

        add(firstMatrix,secondMatrix);
    }

    static void add(int[][] firstMatrix,int[][] secondMatrix){

        int[][] addResult = new int[4][4];

        for (int i = 0 ; i < 2 ; i++){
            for (int j = 0 ; j < 4 ; j++){
                addResult[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        for (int i = 0 ; i < 2 ; i++){
            for (int j = 0 ; j < 4 ; j++){
                System.out.print(addResult[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
