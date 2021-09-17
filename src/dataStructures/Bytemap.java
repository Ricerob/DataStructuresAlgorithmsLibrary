package dataStructures;

import processing.core.PApplet;
import java.util.Random;

//Robby Rice, Sep 2021

/* Basic implementation/ recreation of a Bitmap in Java. A few notes:
 * Only stores byte values, hopes to visualize black/ white images
 * Implementation is using signed bytes, so -128 - 127, as Java doesn't natively have unsigned bytes.
 */
public class Bytemap extends PApplet {
    byte map[][];

    //Initializes an empty Bytemap with all 0's with size 100 x 100
    public Bytemap(){
        map = new byte[100][100];
        fillWithZeroes();
    }

    //Initializes an empty Bytemap with user-defined size
    public Bytemap(int length, int width) {
        map = new byte[length][width];
        fillWithZeroes();
    }

    //Randomizes bytes of given Bytemap
    public Bytemap randomize(Bytemap map){
        Random rand = new Random();

        for(int i = 0; i < map.map.length; i++) {
            for(int j = 0; j < map.map[0].length; j++){
                map.map[i][j] = (byte)(rand.nextInt() % 127);
                if(rand.nextInt() % 2 == 0){
                    map.map[i][j] = map.map[i][j];
                }
            }
        }
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

    public void drawStart() {
        draw();
    }

    public void draw() {
        //PApplet.main("MainClass");
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                fill((int) map[i][j] + 128);
                rect(i, j, 1, 1);
            }
        }
    }

    public void setup(){
        size(map.length, map[0].length);
    }

}