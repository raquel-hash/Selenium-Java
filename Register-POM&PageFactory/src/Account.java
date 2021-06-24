public class Account {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String gender;
    private String[] hobbies;
    private String[] languages;
    private String skill;
    private String country;
    private String state;
    private String year;
    private String month;
    private String day;
    private String password;
    private String confirmPassword;
    private String file;

    public Account(String email, String password, String confirmPassword){
        this.email=email;
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

    public String getGender() {
        return gender;
    }

    public Account setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public Account setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public String[] getLanguages() {
        return languages;
    }

    public Account setLanguages(String[] languages) {
        this.languages = languages;
        return this;
    }

    public String getSkill() {
        return skill;
    }

    public Account setSkill(String skill) {
        this.skill = skill;
        return this;
    }

    public String getState() {
        return state;
    }

    public Account setState(String state) {
        this.state = state;
        return this;
    }

    public String getYear() {
        return year;
    }

    public Account setYear(String year) {
        this.year = year;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public Account setMonth(String month) {
        this.month = month;
        return this;
    }

    public String getDay() {
        return day;
    }

    public Account setDay(String day) {
        this.day = day;
        return this;
    }

    public String getFile() {
        return file;
    }

    public Account setFile(String file) {
        this.file = file;
        return this;
    }
}

