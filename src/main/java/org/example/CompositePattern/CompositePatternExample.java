package org.example.CompositePattern;




//Component Interface: Defines common behavior for both individual objects and composites.
//Leaf (Individual Object): Represents a single object with no children.
//Composite (Container Object): Holds child components (both leaves and other composites).
public class CompositePatternExample {
    public static void main(String[] args) {
        File file1 = new File("Document1.txt");
        File file2 = new File("Image.png");

        Folder folder1 = new Folder("My Documents");
        folder1.add(file1);
        folder1.add(file2);

        File file3 = new File("Video.mp4");
        Folder mainFolder = new Folder("Root");
        mainFolder.add(folder1);
        mainFolder.add(file3);

        // Display the structure
        mainFolder.showDetails();
    }
}
