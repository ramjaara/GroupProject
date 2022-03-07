package com.company.objects;

import com.company.objects.floorItems.FloorItem;
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
    private List<Wall> walls;
    private List<Spawner> spawners;
    private String completeClause;
    private File source;

    public Layout(String location) {
        source = new File(location);
        populateLayout();
    }

    public static void main(String[] args){
        Layout layout = new Layout("com/company/layouts/level1");
        layout.populateLayout();
        System.out.println(layout.walls);
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
                    this.walls.add(wall);
                }
            }
        } catch (Exception e) {
            System.out.println("There was an error loading layout");
            System.out.println(e);
        }
    }
}
