package model;

public class ChildCompany {

    private String name;

    private String address;

    private String state;

    private String phone;


    public ChildCompany(String name, String address, String state, String phone) {
        this.name = name;
        this.address = address;
        this.state = state;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildCompany that = (ChildCompany) o;
        return name.equals(that.name) &&
                address.equals(that.address) &&
                state.equals(that.state) &&
                phone.equals(that.phone);
    }
}
