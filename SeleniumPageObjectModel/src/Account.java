public class Account {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String stateProvince;
    private String postalCode;
    private String userName;
    private String password;
    private String confirmPassword;
    private String country;


    public Account(String email, String userName, String password, String confirmPassword){
        this.email=email;
        this.userName=userName;
        this.password=password;
        this.confirmPassword=confirmPassword;
    }

    public String getFirstName(){
        return firstName;
    }

    public  Account setFirstName(String firstName){
        this.firstName=firstName;
        return this;
    }

    public String getLastName(){
        return  lastName;
    }

    public Account setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Account setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Account setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Account setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public Account setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Account setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Account setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public Account setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Account setCountry(String country) {
        this.country = country;
        return this;
    }
}
