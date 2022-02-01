package data;

public class RegByCardInfo {
    private final String city;
    private final String date;
    private final String changeDate;
    private final String name;
    private final String phone;

    public RegByCardInfo(String city, String date, String changeDate, String name, String phone) {
        this.city = city;
        this.date = date;
        this.changeDate = changeDate;
        this.name = name;
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getChangeDate() {
        return changeDate;
    }
}