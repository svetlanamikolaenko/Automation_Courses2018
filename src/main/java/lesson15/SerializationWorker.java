package lesson15;

import java.io.*;

public class SerializationWorker {
    private static final String STORAGE_ROOT_FOLDER = "/home/svitlanamykolaienko/testData/";
    public static void serializeStorage(Object o, String fileName)
    {
        File folder = new File(STORAGE_ROOT_FOLDER);
        File file = new File(folder.getAbsolutePath()+"/"+fileName+".ser");
    if(!file.exists()){ folder.mkdirs(); }
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
    {
        oos.writeObject(o);
    System.out.println("Object saved in storage file: "+fileName);
    }
    catch (FileNotFoundException e)
    { e.printStackTrace();
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
    }
    public static Object deserialzeStorage(String fileName) {
        File file = new File(STORAGE_ROOT_FOLDER+fileName+".ser");
    Object o = null; try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        { o = ois.readObject();
    } catch (FileNotFoundException e) { return null; } catch (Exception ex) { ex.printStackTrace();
    }
    System.out.println("Object loaded from storage file: "+fileName);
    return o; } }
