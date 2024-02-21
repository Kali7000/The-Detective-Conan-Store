import java.io.*;

public class Serialization {
    public void save(Object obj, String filename) {
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(obj);

            out.close();
            file.close();

            System.out.println("Saving " + filename + " is complete!\n");
        } catch(IOException ex) {
            System.out.println("Exception has been caught");
        }
    }

    public Object download(String filename) {
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            Object obj = in.readObject();

            in.close();
            file.close();

            System.out.println("Download " + filename + " is complete!\n");
            return obj;
        } catch(IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
