package spkrash.krashinc.addressbook.model;

public class ContactData {
   private String firstName;
   private String middleName;
   private String lastName;
   private String nickname;
   private String address;
   private String mobileNum;
   private String persEmail;
   private int id = Integer.MAX_VALUE;

   public ContactData withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
   }

   public ContactData withMiddleName(String middleName) {
      this.middleName = middleName;
      return this;
   }

   public ContactData withLastName(String lastName) {
      this.lastName = lastName;
      return this;
   }

   public ContactData withNickname(String nickname) {
      this.nickname = nickname;
      return this;
   }

   public ContactData withAddress(String address) {
      this.address = address;
      return this;
   }

   public ContactData withMobileNum(String mobileNum) {
      this.mobileNum = mobileNum;
      return this;
   }

   public ContactData withPersEmail(String persEmail) {
      this.persEmail = persEmail;
      return this;
   }

   public ContactData withId(int id) {
      this.id = id;
      return this;
   }

   public int getId() {
      return id;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public String getMiddleName()
   {
      return middleName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public String getNickname()
   {
      return nickname;
   }

   public String getAddress()
   {
      return address;
   }

   public String getMobileNum()
   {
      return mobileNum;
   }

   public String getPersEmail()
   {
      return persEmail;
   }

   @Override
   public String toString() {
      return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", id='" + id + '\'' +
            '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ContactData that = (ContactData) o;

      if (id != that.id) return false;
      if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
      if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
      return address != null ? address.equals(that.address) : that.address == null;

   }

   @Override
   public int hashCode() {
      int result = firstName != null ? firstName.hashCode() : 0;
      result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
      result = 31 * result + (address != null ? address.hashCode() : 0);
      result = 31 * result + id;
      return result;
   }
}
