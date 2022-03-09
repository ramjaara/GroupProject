package com.company.objects;

import com.company.objects.floorItems.Spawner;
import com.company.objects.floorItems.Wall;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//the string location is the location of the file
//that the layout is read from
//layout files are formatted as each line is either
//a wall, spawner, or floor object
//delimiter is %
//last line is the complete clause and anything that
//may be required (if it enemies killed, then the
//line after has an int type that is passed to the
//loop repo
public class Layout {
    private List<Wall> walls = new ArrayList<>();
    private List<Spawner> spawners = new ArrayList<>();
    private String completeClause;
    private File source;

    public Layout(String location) {
        source = new File(location);
        populateLayout();
    }

    public static void main(String[] args){
        Layout layout = new Layout("src/com/company/layouts/level1");
        System.out.println(layout.walls);
    }

    public void addWall(Wall wall) {
        this.walls.add(wall);
    }

    private void populateLayout() {
        try {
            Scanner reader = new Scanner(this.source);
            while (reader.hasNextLine()) {
                String fileLine = reader.next();
                List<String> splitFileLine = new ArrayList<>(Arrays.asList(fileLine.split("&")));
                if(splitFileLine.get(0).equals("w")){
                    Point position = new Point(Integer.parseInt(splitFileLine.get(1)), Integer.parseInt(splitFileLine.get(2)));
                    int height = Integer.parseInt(splitFileLine.get(3));
                    int width = Integer.parseInt(splitFileLine.get(4));
                    Wall wall = new Wall(position, height, width);
                    this.addWall(wall);
                }
            }
        }catch(Exception e){

        }
    }

}
