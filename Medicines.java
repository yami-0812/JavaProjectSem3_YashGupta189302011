public class Medicines{
    String medid;
    String medname;
    int qty;
    int price;
    
    void display(Medicines m){
        System.out.println("Medicine ID: "+m.medid+" Medicine Name: "+m.medname+" Medicine Price: "+m.price);
    }

    Medicines(String medid,String medname,int qty,int price){
        this.qty = qty;
        this.price = price;
        this.medid = medid;
        this.medname = medname;
    }
    void setmedid(String medid){
        this.medid = medid;
    }
    void setmedname(String medname){
        this.medname = medname;
    }
    void setqty(int qty){
        this.qty = qty;
    }
    void setprice(int price){
        this.price = price;
    }
}
