package plikiorazkatalogi;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class PlikiOrazKatalogi {

    public static void main(String[] args) 
    {
        try 
        {
            File katalog = new File("cos"+File.separator+"php"+File.separator+"mysql");
            katalog.mkdirs();
            
            File plik2 = new File("cos"+File.separator+"php"+File.separator+"mysql", "lekcja1.txt");
            if(!plik2.exists())
                plik2.createNewFile();
            
            File plik = new File("test.txt");
            
            if(!plik.exists())
                plik.createNewFile();
            
            System.out.println(plik.getPath());
            System.out.println(plik.getCanonicalPath()); // kanoniczna - zawsze prawdziwa
            System.out.println(plik.getAbsolutePath()); // absolutna dosłowna ścierzka
            
            System.out.println("Czy mogę pisać?: "+ plik.canWrite());
            System.out.println("Czy mogę odpalić?: "+ plik.canExecute());
            System.out.println("Czy mogę czytać?: "+ plik.canRead());
            System.out.println("Czy plik jest ukryty?: "+ plik.isHidden());
            System.out.println("Czy jest plikiem?: "+ plik.isFile());
            System.out.println("Ostatnia modyfikacja: "+ new Date(plik.lastModified()));
            System.out.println("Długość pliku w bajtach: "+ plik.length());
            
            System.out.println("----------------------------------");
            PlikiOrazKatalogi.wypiszScierzki(new File(System.getProperty("user.dir")));
            System.out.println("----------------------------------");
            
            //plik.delete();
        } 
        catch (IOException ex) 
        {
            System.out.println(ex.getMessage());
        }
        
        //System.out.println(System.getProperty("user.dir"));
        //System.out.println(System.getProperty("user.home"));
        //System.out.println(System.getProperty("java.home"));
    }
    
    public static void wypiszScierzki(File nazwaScierzki)
    {
        String[] nazwyPlikówIKatalogow = nazwaScierzki.list();
        System.out.println(nazwaScierzki.getPath());
        for(int i = 0; i < nazwyPlikówIKatalogow.length; i++)
        {
            File p = new File(nazwaScierzki.getPath(), nazwyPlikówIKatalogow[i]);
            if(p.isFile())
                System.out.println(p.getPath());
            
            if(p.isDirectory())
                wypiszScierzki(new File(p.getPath()));
        }
    }
}
