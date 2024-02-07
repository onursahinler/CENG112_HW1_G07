package Recycling;

import java.util.List;

import FileAccess.FileIO;

public class GarbageRecyclingAppInitializer {
    private static final int TRASH_CAN_SIZE = 450;
    private static final String FILE_NAME = "garbage.txt";

    public static void initialize() {
        // Create trash can
        TrashCan trashCan = new TrashCan();

        // Read garbage data from file
        List<String> garbageData = (List<String>) FileIO.readTrashCan(FILE_NAME);

        // Create and add garbage objects to trash can
        for (String line : garbageData) {
            String[] parts = line.split(", ");
            String name = parts[0];
            String type = parts[1];
            int amount = Integer.parseInt(parts[2].trim());

            // Create garbage objects according to the amount
            for (int i = 0; i < amount; i++) {
                if (type.equalsIgnoreCase("paper")) {
                    trashCan.add(new Paper(name, amount));
                } else if (type.equalsIgnoreCase("plastic")) {
                    trashCan.add(new Plastic(name, amount));
                } else if (type.equalsIgnoreCase("metal")) {
                    trashCan.add(new Metal(name, amount));
                } else if (type.equalsIgnoreCase("glass")) {
                    trashCan.add(new Glass(name, amount));
                } else if (type.equalsIgnoreCase("organic")) {
                    trashCan.add(new Organic(name, amount));
                } else {
                    System.out.println("Invalid garbage type: " + type);
                }
            }
        }

        // Create recycling bins
        RecyclingBin paperBin = new PaperRecycleBin((int)(Math.random()*11)+5);
        RecyclingBin plasticBin = new PlasticRecycleBin((int)(Math.random()*11)+5);
        RecyclingBin metalBin = new MetalRecycleBin((int)(Math.random()*11)+5);
        RecyclingBin glassBin = new GlassRecycleBin((int)(Math.random()*11)+5);
        RecyclingBin organicBin = new OrganicRecycleBin((int)(Math.random()*11)+5);
        RecyclingBin fabricBin = new FabricRecycleBin((int)(Math.random()*11)+5);

        // Add garbage to recycling bins
        List<Garbage> trashCanContent = trashCan.getContents();
        for (Garbage garbage : trashCanContent) {
            if (garbage instanceof Paper) {
                paperBin.addRecycle(garbage);
            } else if (garbage instanceof Plastic) {
                plasticBin.addRecycle(garbage);
            } else if (garbage instanceof Metal) {
                metalBin.addRecycle(garbage);
            } else if (garbage instanceof Glass) {
                glassBin.addRecycle(garbage);
            } else if (garbage instanceof Organic) {
                organicBin.addRecycle(garbage);
            }
        }

        // Update trash can content
        trashCan.updateTrashCan();

        // Print recycling bin contents and trash can content
        System.out.println("Plastic Recycling Bin: size " + plasticBin.getSize() + ", content " + plasticBin.getGarbageList());
        System.out.println("Paper Recycling Bin: size " + paperBin.getSize() + ", content " + paperBin.getGarbageList());
        System.out.println("Metal Recycling Bin: size " + metalBin.getSize() + ", content " + metalBin.getGarbageList());
        System.out.println("Glass Recycling Bin: size " + glassBin.getSize() + ", content " + glassBin.getGarbageList());
        System.out.println("Organic Recycling Bin: size " + organicBin.getSize() + ", content " + organicBin.getGarbageList());
        System.out.println("The Trash Can: updated content ");
    }
}
