package icezhg.spweb.domain;

import java.io.Serializable;

/**
 * Created by zhongjibing on 2017/4/16.
 */
public class Ssc implements Serializable {
    private static final long serialVersionUID = -6186721448925784427L;

    private int id;
    private int wa;
    private int qa;
    private int ba;
    private int sh;
    private int ge;

    public Ssc() {
    }

    public Ssc(int id, int wa, int qa, int ba, int sh, int ge) {
        this.id = id;
        this.wa = wa;
        this.qa = qa;
        this.ba = ba;
        this.sh = sh;
        this.ge = ge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWa() {
        return wa;
    }

    public void setWa(int wa) {
        this.wa = wa;
    }

    public int getQa() {
        return qa;
    }

    public void setQa(int qa) {
        this.qa = qa;
    }

    public int getBa() {
        return ba;
    }

    public void setBa(int ba) {
        this.ba = ba;
    }

    public int getSh() {
        return sh;
    }

    public void setSh(int sh) {
        this.sh = sh;
    }

    public int getGe() {
        return ge;
    }

    public void setGe(int ge) {
        this.ge = ge;
    }

    @Override
    public String toString() {
        return "Ssc{" +
                "id=" + id +
                ", wa=" + wa +
                ", qa=" + qa +
                ", ba=" + ba +
                ", sh=" + sh +
                ", ge=" + ge +
                '}';
    }
}
