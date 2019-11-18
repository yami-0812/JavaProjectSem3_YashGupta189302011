public class Manufacturers{
    String manid;
    String manname;
    String mobileno;
    
    void display(Manufacturers p){
        System.out.println("Manufacturer ID: "+p.manid+" Manufacturer Name: "+p.manname+" Manufacturer mobileno: "+p.mobileno);
    }

    Manufacturers(String manid,String manname,String mobileno){
        this.mobileno = mobileno;
        this.manid = manid;
        this.manname = manname;
    }
    void setselid(String manid){
        this.manid = manid;
    }
    void setselname(String manname){
        this.manname = manname;
    }
    void setmobileno(String mobileno){
        this.mobileno = mobileno;
    }
}
