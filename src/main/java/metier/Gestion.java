package metier;

import dao.ICalcul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("gestion")
public class Gestion implements IGestion {
    @Autowired
    @Qualifier("cal2")
    private ICalcul cal;
    public double calcul() {
        return cal.getValue()*10;
    }
    public void setCal(ICalcul cal) {
        this.cal = cal;
    }
    public Gestion() {
    }}