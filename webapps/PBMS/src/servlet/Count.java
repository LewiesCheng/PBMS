package servlet;

/**
 * Created by JoyHwong on 16/6/3.
 * copyright @ 2016 All right reserved.
 * follow me on github https://github.com/JoyHwong
 */
public class Count {
    private float income;
    private float spend;
    private float totalIncome;
    private float totalSpend;
    private String year;
    private String month;
    private float food;
    private float rent;
    private float educate;
    private float utilitie;
    private float medical;


    public Count() {
        this.income = this.spend = this.totalSpend = this.totalIncome = 0;
    }

    public float getIncome() {
        return income;
    }

    public float getSpend() {
        return spend;
    }

    public float getTotalIncome() {
        return totalIncome;
    }

    public float getTotalSpend() {
        return totalSpend;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public float getFood() {
        return food;
    }

    public float getRent() {
        return rent;
    }

    public float getEducate() {
        return educate;
    }

    public float getUtilitie() {
        return utilitie;
    }

    public float getMedical() {
        return medical;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public void setSpend(float spend) {
        this.spend = spend;
    }

    public void setTotalIncome(float totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setTotalSpend(float totalSpend) {
        this.totalSpend = totalSpend;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setFood(float food) {
        this.food = food;
    }

    public void setRent(float rent) {
        this.rent = rent;
    }

    public void setEducate(float educate) {
        this.educate = educate;
    }

    public void setUtilitie(float utilitie) {
        this.utilitie = utilitie;
    }

    public void setMedical(float medical) {
        this.medical = medical;
    }
}
