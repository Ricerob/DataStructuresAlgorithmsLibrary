package dataStructures;

//Robby Rice, Sep 2021

import org.jetbrains.annotations.NotNull;

/* Basic implementation/ recreation of a Bitmap in Java. A few notes:
 * Only stores byte values, hopes to visualize black/ white images
 */
public class Bitmap {
    byte map[][];

    //Initializes an empty Bitmap with all 0's with size 100 x 100
    Bitmap(){
        map = new byte[100][100];
        fillWithZeroes();
    }

    Bitmap(int length, int width) {
        map = new byte[length][width];
        fillWithZeroes();
    }

    Bitmap(byte[][] givenArray) throws NullPointerException{
        for(int i = 0; i < givenArray.length; i++){
            for(int j = 0; j < givenArray[0].length; j++){
                map[i][j] = givenArray[i][j];
            }
        }
    }

    //Randomizes bytes of given
    public Bitmap randomize(Bitmap map){
        return map;
    }


    private int fillWithZeroes() {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = 0;
            }
        }
        return 0;
    }

}