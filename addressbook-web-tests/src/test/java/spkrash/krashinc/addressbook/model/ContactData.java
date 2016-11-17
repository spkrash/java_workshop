package spkrash.krashinc.addressbook.model;

public class ContactData {
   private final String firstName;
   private final String middleName;
   private final String lastName;
   private final String nickname;
   private final String address;
   private final String mobileNum;
   private final String persEmail;
   private int id;

   public ContactData(String firstName, String middleName, String lastName, String nickname, String address, String mobileNum, String persEmail, int id)
   {
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.nickname = nickname;
      this.address = address;
      this.mobileNum = mobileNum;
      this.persEmail = persEmail;
      this.id = id;
   }

   public ContactData(String firstName, String middleName, String lastName, String nickname, String address, String mobileNum, String persEmail)
   {
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.nickname = nickname;
      this.address = address;
      this.mobileNum = mobileNum;
      this.persEmail = persEmail;
      this.id = Integer.MAX_VALUE;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
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

      if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
      if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
      return address != null ? address.equals(that.address) : that.address == null;

   }

   @Override
   public int hashCode() {
      int result = firstName != null ? firstName.hashCode() : 0;
      result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
      result = 31 * result + (address != null ? address.hashCode() : 0);
      return result;
   }
}
