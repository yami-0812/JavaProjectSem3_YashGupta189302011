public class Pharmacists{
    String pharmaid;
    String pharmaname;
    String mobileno;
    
    void display(Pharmacists p){
        System.out.println("Pharamacist ID: "+p.pharmaid+" Pharamacist Name: "+p.pharmaname+" Pharamacist mobileno: "+p.mobileno);
    }

    Pharmacists(String pharmaid,String pharmaname,String mobileno){
        this.mobileno = mobileno;
        this.pharmaid = pharmaid;
        this.pharmaname = pharmaname;
    }
    void setretid(String pharmaid){
        this.pharmaid = pharmaid;
    }
    void setretname(String pharmaname){
        this.pharmaname = pharmaname;
    }
    void setmobileno(String mobileno){
        this.mobileno = mobileno;
    }
}
