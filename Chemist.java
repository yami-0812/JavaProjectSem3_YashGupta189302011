    import java.io.*;
    import java.util.*;
class Chemist{      
    static BufferedReader medfileread = null,manfileread = null,pharmafileread = null;
    static BufferedWriter medfilewrite = null,manlog = null,pharmalog = null,patlog = null,manfilewrite=null,pharmafilewrite=null;
    static void fnalmed(ArrayList<Medicines> medetails,ArrayList<Manufacturers> mandetails,ArrayList<Pharmacists> pharmadetails) throws IOException{
            manfilewrite = new BufferedWriter(new FileWriter("Txt Files/Manufacturers.txt"));
            pharmafilewrite = new BufferedWriter(new FileWriter("Txt Files/Pharmacists.txt"));
            medfilewrite = new BufferedWriter(new FileWriter("Txt Files/Medicines.txt"));
        for(Medicines med : medetails){
            medfilewrite.write(med.medid);  
            medfilewrite.write(" "+med.medname);
            medfilewrite.write(" "+med.price);
            medfilewrite.write(" "+med.qty);
            medfilewrite.newLine();
        }
        for(Manufacturers man : mandetails){
            manfilewrite.write(man.manid);
            manfilewrite.write("  "+man.manname);
            manfilewrite.write("  "+man.mobileno);
            manfilewrite.newLine();
        }
        for(Pharmacists pharma : pharmadetails){
            pharmafilewrite.write(pharma.pharmaid);
            pharmafilewrite.write("  "+pharma.pharmaname);
            pharmafilewrite.write("  "+pharma.mobileno);
            pharmafilewrite.newLine();
        }
        medfilewrite.close();
        manfilewrite.close();
        pharmafilewrite.close();
        manlog.close();
        pharmalog.close();
        patlog.close();
    }
    static void displayMedicines(ArrayList<Medicines> medetails) throws IOException{
        int i=0;
        while (i<medetails.size()){
            medetails.get(i).display(medetails.get(i));
            i++;
        }
    }
    static void setMedicines(ArrayList<Medicines> medetails) throws IOException{
        String currentLine = medfileread.readLine();
        while (currentLine != null){
            String[] med = currentLine.split(" ");
            String mednamef = med[1];
            String medidf = med[0];
            int medpricef = Integer.valueOf(med[2]);
            int medqtyf = Integer.valueOf(med[3]);
            medetails.add(new Medicines(medidf,mednamef,medqtyf,medpricef));
            currentLine = medfileread.readLine();
        }
    }
    static Medicines searchMedicine(BufferedReader reader,ArrayList<Medicines> medetails,int id) throws IOException{
        String[] p = {},med=null;
        int i;
        for(i=0;i<medetails.size();i++){
            if(id==Integer.parseInt(medetails.get(i).medid)){
                break;
            }
        }
        if(i==medetails.size()){
            String medida = Integer.toString(id);
            System.out.println("Enter Medicine Name");
            String medname = reader.readLine();
            int medqty = 0;
            System.out.println("Enter Medicine Price");
            int medprice = Integer.parseInt(reader.readLine());
            medetails.add(new Medicines(medida,medname,medqty,medprice));
        }
        return medetails.get(i);
    }
    static Medicines searchMedicinepharma(BufferedReader reader,ArrayList<Medicines> medetails,int id) throws IOException{
        String[] p = {},med=null;
        int i;
        for(i=0;i<medetails.size();i++){
            if(id==Integer.parseInt(medetails.get(i).medid)){
                break;
            }
        }
        if(i==medetails.size()){
            return new Medicines("null","null",0,0);
        }
        return medetails.get(i);
    }
    static Medicines searchMedicinecus(BufferedReader reader,ArrayList<Medicines> medetails,String name) throws IOException{
        String[] p = {},med=null;
        int i;
        for(i=0;i<medetails.size();i++){
            if(name.equalsIgnoreCase(medetails.get(i).medname)){
                break;
            }
        }
        if(i==medetails.size()){
            return new Medicines("null","null",0,0);
        }
        return medetails.get(i);
    }
    static void setManufacturers(ArrayList<Manufacturers> mandetails) throws IOException{
        String currentLine = manfileread.readLine();
        while (currentLine != null){
            String[] man = currentLine.split("  ");
            String mannamef = man[1];
            String manidf = man[0];
            String manmobf = man[2];
            mandetails.add(new Manufacturers(manidf,mannamef,manmobf));
            currentLine = manfileread.readLine();
        }
    }
    static void setPharmacists(ArrayList<Pharmacists> pharmadetails) throws IOException{
        String currentLine = pharmafileread.readLine();
        while (currentLine != null){
            String[] pharma = currentLine.split("  ");
            String pharmanamef = pharma[1];
            String pharmaidf = pharma[0];
            String pharmamobf = pharma[2];
            pharmadetails.add(new Pharmacists(pharmaidf,pharmanamef,pharmamobf));
            currentLine = pharmafileread.readLine();
        }
    }
    static Manufacturers searchManufacturer(ArrayList<Manufacturers> mandetails,int id,BufferedReader reader) throws IOException{
        int i;
        for(i=0;i<mandetails.size();i++){
            if(id==Integer.parseInt(mandetails.get(i).manid)){
                break;
            }
        }
        if(i==mandetails.size()){
            String manida = Integer.toString(id);
            System.out.println("ID Not Found.\n To Generate new Manufacturer, Enter Manufacturer Id.\nEnter 0000 to return");
            String newid = reader.readLine();
            if(Integer.parseInt(newid)==0){
                return new Manufacturers("null","null","null");
            }
            else{
                manida = newid;
                System.out.println("Enter Manufacturer Name");
                String manname = reader.readLine();
                System.out.println("Enter Manufacturer Mobile No.");
                String manmob = reader.readLine();
                mandetails.add(new Manufacturers(manida,manname,manmob));
            }
        }
        return mandetails.get(i);
    }
    static Pharmacists searchPharmacist(ArrayList<Pharmacists> pharmadetails,int id,BufferedReader reader) throws IOException{
        int i;
        for(i=0;i<pharmadetails.size();i++){
            if(id==Integer.parseInt(pharmadetails.get(i).pharmaid)){
                break;
            }
        }
        if(i==pharmadetails.size()){
            String pharmaida = Integer.toString(id);
            System.out.println("ID Not Found.\n To Generate new Pharmacist, Enter Pharmacist Id.\nEnter 0000 to return");
            String newid = reader.readLine();
            if(Integer.parseInt(newid)==0){
                return new Pharmacists("null","null","null");
            }
            else{
                pharmaida = newid;
                System.out.println("Enter Pharmacist Name");
                String pharmaname = reader.readLine();
                System.out.println("Enter Pharmacist Mobile No.");
                String pharmamob = reader.readLine();
                pharmadetails.add(new Pharmacists(pharmaida,pharmaname,pharmamob));
            }
        }
        return pharmadetails.get(i);
    }
    static void Pharmacist(int c,BufferedReader reader,ArrayList<Medicines> medetails,ArrayList<Pharmacists> pharmadetails) throws IOException{
        try {
            System.out.println("Enter ID");
            int id = Integer.parseInt(reader.readLine());
            if(id>1100&&id<=1200){
                Pharmacists pharmadet = searchPharmacist(pharmadetails,id,reader);
                if(pharmadet.pharmaid.equals("null")){
                    System.out.println("Pharmacist Not Found");
                }
                else{
                    int sum=0;
                    pharmalog.write(pharmadet.pharmaname+":");
                    pharmalog.newLine();
                    System.out.println("Hey, "+pharmadet.pharmaname+". Welcome to The Shop\nEnter Medicine ID to Buy\nEnter 0000 to Exit");
                    int medid = Integer.parseInt(reader.readLine());
                    while(medid!=0){
                        Medicines medtoadd = searchMedicinepharma(reader,medetails,medid);
                        if(medtoadd.medid.equals("null")){
                            System.out.println("Medicine Not Found");
                        }
                        else{
                            System.out.println("Enter Quantity to Buy for "+medtoadd.medname+" :");
                            int medqty = Integer.parseInt(reader.readLine());
                            medtoadd.setqty(medtoadd.qty-medqty);
                            sum+=(0.75*medtoadd.price*medqty);
                            pharmalog.write(medtoadd.medname+"   "+medqty+"   Rs."+0.75*medtoadd.price*medqty);
                            pharmalog.newLine();
                        }
                        medid = Integer.parseInt(reader.readLine());
                    }
                    System.out.println("Total Bill : Rs."+sum);
                    pharmalog.write("Total Bill: Rs."+sum);
                    pharmalog.newLine();
                    pharmalog.write("NEW BILL");
                    pharmalog.newLine();
                }
            }
        } catch(NumberFormatException i){
            System.out.println("Invalid Input");
        }
    }
    static void Patient(int c,BufferedReader reader,ArrayList<Medicines> medetails) throws IOException{
        try {
                int sum=0;
                System.out.println("Enter Your Name");
                String name = reader.readLine();
                patlog.write(name+":");
                patlog.newLine();
                displayMedicines(medetails);
                System.out.println("Hey, "+name+". Welcome to The Shop\nEnter Medicine Name to Buy\nEnter end to Exit");
                String mednam = reader.readLine();
                while(mednam.equalsIgnoreCase("end")==false){
                    Medicines medtoadd = searchMedicinecus(reader,medetails,mednam);
                    if(medtoadd.medid.equals("null")){
                        System.out.println("Medicine Not Found");
                    }
                    else{
                        System.out.println("Enter Quantity to Buy for "+medtoadd.medname+" :");
                        int medqty = Integer.parseInt(reader.readLine());
                        medtoadd.setqty(medtoadd.qty-medqty);
                        sum+=(medtoadd.price*medqty);
                        patlog.write(medtoadd.medname+"   "+medqty+"   Rs."+medtoadd.price*medqty);
                        patlog.newLine();
                    }
                    mednam = reader.readLine();
                }
                System.out.println("Total Bill : Rs."+sum);
                patlog.write("Total Bill: Rs."+sum);
                patlog.newLine();
                patlog.write("NEW BILL");
                patlog.newLine();
        } catch(NumberFormatException i){
            System.out.println("Invalid Input");
        }
    }
    static void Manufacturer(int c,BufferedReader reader,ArrayList<Medicines> medetails,ArrayList<Manufacturers> mandetails) throws IOException{
        try {
            System.out.println("Enter ID");
            int id = Integer.parseInt(reader.readLine());
            if(id>1000&&id<=1100){
                Manufacturers mandet = searchManufacturer(mandetails,id,reader);
                if(mandet.manid.equals("null")){
                    System.out.println("Manufacturer Not Found");
                }
                else{
                    System.out.println("Hey, "+mandet.manname+". Welcome to The Shop\nEnter Medicine Id to buy\nEnter 0000 to Exit");
                    int medid = Integer.parseInt(reader.readLine());
                    while(medid!=0){
                        Medicines medtoadd = searchMedicine(reader,medetails,medid);
                        System.out.println("Enter Quantity for "+medtoadd.medname+" :");
                        int medqty = Integer.parseInt(reader.readLine());
                        medtoadd.setqty(medtoadd.qty+medqty);
                        manlog.write(mandet.manname+":  Added "+medtoadd.medname+"+"+medqty);
                        manlog.newLine();
                        medid = Integer.parseInt(reader.readLine());
                    }
                }
            }
        } catch(NumberFormatException i){
            System.out.println("Invalid Input");
        }
    }
    public static void main(String[] args) throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(ir);
        try 
        {
            medfileread = new BufferedReader(new FileReader("Txt Files/Medicines.txt"));
            manfileread = new BufferedReader(new FileReader("Txt Files/Manufacturers.txt"));
            pharmafileread = new BufferedReader(new FileReader("Txt Files/Pharmacists.txt"));
            manlog = new BufferedWriter(new FileWriter("Txt Files/ManBill.txt",true));
            pharmalog = new BufferedWriter(new FileWriter("Txt Files/pharmaBill.txt",true));
            patlog = new BufferedWriter(new FileWriter("Txt Files/PatientBill.txt",true));
        } 
        catch (FileNotFoundException e) {
            System.out.println("File Not found");
        }
        ArrayList<Medicines> medetails = new ArrayList<Medicines>();
        ArrayList<Manufacturers> mandetails = new ArrayList<Manufacturers>();
        ArrayList<Pharmacists> pharmadetails = new ArrayList<Pharmacists>();
        setMedicines(medetails);
        setManufacturers(mandetails);
        setPharmacists(pharmadetails);
        int i=1;
        while(i>0){
            System.out.println("\n**********welcome to the Pharmacist shop********\nEnter\n m for Manufacturer\n p for Pharmacist\n c for Patient\n and e to exit");
            String c = reader.readLine();
            if(c.equalsIgnoreCase("m")){
                Manufacturer(1, reader, medetails,mandetails);
            }
            else if(c.equalsIgnoreCase("p")){
                Pharmacist(2, reader, medetails,pharmadetails);
            }
            else if(c.equalsIgnoreCase("c")){
                Patient(3, reader, medetails);
            }
            else if(c.equalsIgnoreCase("e")){
                fnalmed(medetails,mandetails,pharmadetails);
                System.exit(0);
            }
            else{
                System.out.println("Invalid Input");
            } 
        }
    }
}