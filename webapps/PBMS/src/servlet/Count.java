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

    public Count() {
        this.income = this.spend = this.totalSpend = this.totalIncome = 0;
    }

    public Count(float income, float spend, float totalIncome, float totalSpend) {
        this.income = income;
        this.spend = spend;
        this.totalIncome = totalIncome;
        this.totalSpend = totalSpend;
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
}
