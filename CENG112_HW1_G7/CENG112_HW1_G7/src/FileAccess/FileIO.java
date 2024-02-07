package FileAccess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Recycling.Fabric;
import Recycling.Garbage;
import Recycling.Glass;
import Recycling.IBag;
import Recycling.Metal;
import Recycling.Organic;
import Recycling.Paper;
import Recycling.Plastic;
import Recycling.TrashCan;

public class FileIO {
    private static final String FILE_NAME = "garbage.txt";

    public static IBag<Garbage> readTrashCan(String FILE_NAME) {
        IBag<Garbage> trashCan = (IBag<Garbage>) new TrashCan();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                String name = tokens[0];
                String type = tokens[1];
                int quantity = Integer.parseInt(tokens[2]);
                switch (type) {
                    case "plastic":
                        trashCan.add(new Plastic(name, quantity));
                        break;
                    case "glass":
                        trashCan.add(new Glass(name, quantity));
                        break;
                    case "paper":
                        trashCan.add(new Paper(name, quantity));
                        break;
                    case "metal":
                        trashCan.add(new Metal(name, quantity));
                        break;
                    case "organic":
                        trashCan.add(new Organic(name, quantity));
                        break;
                    case "fabric":
                        trashCan.add(new Fabric(name, quantity));
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + FILE_NAME + " could not be found.");
        } catch (IOException e) {
            System.out.println("Error reading from " + FILE_NAME);
        }
        return trashCan;
    }

    public static boolean updateTrashCan(IBag<Garbage> trashCan) {
        List<Garbage> items = new ArrayList<>(trashCan.getItemCount());
        trashCan.dump();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Garbage item : items) {
                String line = item.getName() + "," + item.getType() + "," + item.getQuantity();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to " + FILE_NAME);
            return false;
        }
        return true;
    }
}


