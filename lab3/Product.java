import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private String _name;
    private Date _manDate;
    private Date _expDate;
    private float _price;

    public Product(String name, Date manDate, Date expDate, float price){
        _name = name;
        _manDate = manDate;
        _expDate = expDate;
        _price = price;
    }

    public Date GetExpDate(){
        return _expDate;
    }
    public Date GetManDate(){
        return _manDate;
    }

    public float GetPrice(){
        return _price;
    }
    public String GetName(){
        return _name;
    }
    public void SetPrice(float value){
        this._price = value;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Product other = (Product) obj;
        if (_name == null) {
            if (other._name != null)
                return false;
        } else if (!_name.equals(other._name))
            return false;
        return true;
    }

    public String toString() {
        return String.format("name: " + GetName() + "  manufacturing date: " + new SimpleDateFormat("dd-MM-yyyy").format(GetManDate()) + "  price: " + GetPrice());
    }
}
