import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int pointCount = 0;
        for(Point p : s.getPoints()){
            pointCount++;
        }
        return pointCount;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avg = getPerimeter(s)/getNumPoints(s);
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double distance = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(distance < currDist){
                distance = currDist;
            }
        }
        return distance;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        for(Point p : s.getPoints()){
            double pX = p.getX();
            if(pX>largestX){
                largestX = pX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestP = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length>largestP){
                largestP = length;
            }
        }
        return largestP;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double largestP = 0.0;
        File temp = null;    // replace this code
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length>largestP){
                largestP = length;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int counter = getNumPoints(s);
        System.out.println("Points Count = "+counter);
        double avg = getAverageLength(s);
        System.out.println("Shape average side length = "+avg);
        double side = getLargestSide(s);
        System.out.println("Longest side = "+side);
        double lX = getLargestX(s);
        System.out.println("Largest X = "+lX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        //double largestP = getLargestPerimeterMultipleFiles();
        //System.out.println("Largest Parameter = "+largestP);
        String f = getFileWithLargestPerimeter();
        System.out.println("File with largest parameter = "+f);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}
