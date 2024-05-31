

package model;
import java.sql.Date;

public class VoucherDBO {
    private String code;
    private double discount;
    private Date begin;
    private Date end;

    public VoucherDBO() {
    }

    public VoucherDBO(String code, double discount, Date begin, Date end) {
        this.code = code;
        this.discount = discount;
        this.begin = begin;
        this.end = end;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "VoucherDBO{" + "code=" + code + ", discount=" + discount + ", begin=" + begin + ", end=" + end + '}';
    }

}
