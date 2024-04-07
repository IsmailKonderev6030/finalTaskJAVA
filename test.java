import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

class NoteBook{
    // 0.mainNameNT;
    // 1.String modelNT;
    // 2.String memoryTypeNT;
    // 3.String memorySizeNT;
    // 4.String RAM_NT;
    // 5.String OS_NT;
    // 6.String colorNT;

    ArrayList<String> listSpecification = new ArrayList<String>();

    NoteBook(ArrayList<String> specification){
        listSpecification = specification;
    }
}

class NoteBooks{
    private Integer ID = 0;
    private Map<Integer,NoteBook> Catalog = new HashMap<Integer,NoteBook>();

    NoteBooks(){}
    NoteBooks(NoteBook forAdd){
        ID++;
        Catalog.put(ID,forAdd);
    }
    public void addNewNoteBook(NoteBook forAdd){
        ID++;
        Catalog.put(ID,forAdd);
    }
    public void deleteNoteBookByID(Integer ID){
        Catalog.remove(ID);
    }
    public void deleteAllNoteBooks(){
        Catalog.clear();
    }

    public void printAllNoteBooks(){
        for(Map.Entry<Integer,NoteBook> it : Catalog.entrySet()){
            System.out.println("ID: " + it.getKey());
            System.out.println("Name: " + it.getValue().listSpecification.get(0));
            System.out.println("Model: " + it.getValue().listSpecification.get(1));
            System.out.println("Memory type: " + it.getValue().listSpecification.get(2));
            System.out.println("Memory size: " + it.getValue().listSpecification.get(3));
            System.out.println("RAM: " + it.getValue().listSpecification.get(4));
            System.out.println("OS: " + it.getValue().listSpecification.get(5));
            System.out.println("Color: " + it.getValue().listSpecification.get(6));
            System.out.println("");
        }
    }
    public void printNoteBookByID(Integer ID){
        System.out.println("ID: " + ID);
        System.out.println("Name: " + Catalog.get(ID).listSpecification.get(0));
        System.out.println("Model: " + Catalog.get(ID).listSpecification.get(1));
        System.out.println("Memory type: " + Catalog.get(ID).listSpecification.get(2));
        System.out.println("Memory size: " + Catalog.get(ID).listSpecification.get(3));
        System.out.println("RAM: " + Catalog.get(ID).listSpecification.get(4));
        System.out.println("OS: " + Catalog.get(ID).listSpecification.get(5));
        System.out.println("Color: " + Catalog.get(ID).listSpecification.get(6));
        System.out.println("");
    }
    public void printNoteBooksByOptions(OptionsList OP){
        if(OP.selectedOptions.isEmpty()) return;

        Set<Integer> IDS = new HashSet<Integer>(Catalog.keySet());

        for(Map.Entry<Integer,Integer> it : OP.selectedOptions.entrySet()){
            for(Map.Entry<Integer,NoteBook> NT : Catalog.entrySet()){
                if(NT.getValue().listSpecification.get(it.getKey()) != OP.OPList.get(it.getKey()).get(it.getValue())){
                    IDS.remove(NT.getKey());
                }
            }
        }

        for(Integer id : IDS){
            printNoteBookByID(id);
        }
    }
}

class OptionsList{
    public ArrayList<ArrayList<String>> OPList = new ArrayList<ArrayList<String>>();            // 0 MainNameList
                                                                                                // 1 ModelList
                                                                                                // 2 MemoryTypeList
                                                                                                // 3 MemorySizeList
                                                                                                // 4 RAM_List
                                                                                                // 5 OS_List
                                                                                                // 6 ColorsList

    public Map<Integer,Integer> selectedOptions = new HashMap<Integer,Integer>();

    OptionsList(){
        OPList.add(new ArrayList<String>(Arrays.asList("Lenova","Acer","HP","IBM")));
        OPList.add(new ArrayList<String>(Arrays.asList("A1","A2","A3","A4","A5","A6")));
        OPList.add(new ArrayList<String>(Arrays.asList("HDD","SSD")));
        OPList.add(new ArrayList<String>(Arrays.asList("180GB","260GB","500GB","1TB")));
        OPList.add(new ArrayList<String>(Arrays.asList("1GB","2GB","4GB","8GB","16GB","32GB")));
        OPList.add(new ArrayList<String>(Arrays.asList("Windows","Mac","Linux")));
        OPList.add(new ArrayList<String>(Arrays.asList("white","black","gray")));
    }

    public void selectOptions(){
        Scanner in = new Scanner(System.in);

        System.out.println("1.Name\n2.Model\n3.Memory type\n4.Memory size\n5.RAM\n6.OS\n7.Color");
        System.out.println("Enter number: ");
        int i1 = in.nextInt();

        int i=1;
        for(String it : OPList.get(i1 - 1)){
            System.out.println(i + "." + it);
            i++;
        }
        System.out.println("Enter number: ");
        int i2 = in.nextInt();

        selectedOptions.put(i1 - 1, i2 - 1);
    }
    public void printSelectedOptions(){
        for(Map.Entry<Integer,Integer> it : selectedOptions.entrySet()){
            System.out.print(OPList.get(it.getKey()).get(it.getValue()) + " ");
        }
        System.out.println("");
    }
    public void clearOptions(){
        selectedOptions.clear();
    }
}


public class test{ 
      
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);

        OptionsList OP = new OptionsList();


        NoteBooks NT = new NoteBooks();
        NT.addNewNoteBook(new NoteBook(new ArrayList<String>(Arrays.asList(OP.OPList.get(0).get(0),OP.OPList.get(1).get(4),OP.OPList.get(2).get(0), OP.OPList.get(3).get(1), OP.OPList.get(4).get(0),OP.OPList.get(5).get(0),OP.OPList.get(6).get(1)))));
        NT.addNewNoteBook(new NoteBook(new ArrayList<String>(Arrays.asList(OP.OPList.get(0).get(3),OP.OPList.get(1).get(2),OP.OPList.get(2).get(1), OP.OPList.get(3).get(0), OP.OPList.get(4).get(0),OP.OPList.get(5).get(0),OP.OPList.get(6).get(1)))));
        NT.addNewNoteBook(new NoteBook(new ArrayList<String>(Arrays.asList(OP.OPList.get(0).get(1),OP.OPList.get(1).get(0),OP.OPList.get(2).get(0), OP.OPList.get(3).get(2), OP.OPList.get(4).get(0),OP.OPList.get(5).get(0),OP.OPList.get(6).get(0)))));

        int command = -1;

        do {
            System.out.println("1.Show all notebooks");
            System.out.println("2.Select options");
            System.out.println("3.Print selected options");
            System.out.println("4.Clear options");
            System.out.println("5.Print notebooks by options");
            System.out.println("0.Exit");
            System.out.println("Enter command: ");
            command = in.nextInt();

            switch(command){
                case 1:
                    NT.printAllNoteBooks();
                break;
                case 2:
                    OP.selectOptions();
                break;
                case 3:
                    OP.printSelectedOptions();
                break;
                case 4:
                    OP.clearOptions();
                break;
                case 5:
                    NT.printNoteBooksByOptions(OP);
                break;
            }

        } while (command != 0);
    }
}