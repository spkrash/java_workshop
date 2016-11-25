package spkrash.krashinc.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("contact")
public class ContactData {
   @Expose
   private String firstName;
   @Expose
   private String middleName;
   @Expose
   private String lastName;
   @Expose
   private String nickname;
   @Expose
   private String address;
   @Expose
   private String mobilePhone;
   @Expose
   private String homePhone;
   @Expose
   private String homePhone2;
   @Expose
   private String workPhone;
   private String allPhones;
   @Expose
   private String email;
   @Expose
   private String email2;
   @Expose
   private String email3;
   private String allEmails;
   @XStreamOmitField
   private int id = Integer.MAX_VALUE;
   private File photo;

   public File getPhoto() {
      return photo;
   }

   public ContactData withPhoto(File photo) {
      this.photo = photo;
      return this;
   }

   public String getEmail2() {
      return email2;
   }

   public ContactData withEmail2(String email2) {
      this.email2 = email2;
      return this;
   }

   public String getEmail3() {
      return email3;
   }

   public ContactData withEmail3(String email3) {
      this.email3 = email3;
      return this;
   }

   public ContactData withAllEmail(String allEmails) {
      this.allEmails = allEmails;
      return this;
   }

   public String getAllEmails() {
      return allEmails;
   }

   public String getHomePhone2() {
      return homePhone2;
   }

   public ContactData withHomePhone2(String homePhone2) {
      this.homePhone2 = homePhone2;
      return this;
   }


   public String getAllPhones() {
      return allPhones;
   }

   public ContactData withAllPhones(String allPhones) {
      this.allPhones = allPhones;
      return this;
   }


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
      this.mobilePhone = mobileNum;
      return this;
   }

   public ContactData withHomePhone(String homePhone) {
      this.homePhone = homePhone;
      return this;
   }

   public ContactData withWorkPhone(String workPhone) {
      this.workPhone = workPhone;
      return this;
   }

   public ContactData withEmail(String email) {
      this.email = email;
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

   public String getMobilePhone()
   {
      return mobilePhone;
   }

   public String getHomePhone()
   {
      return homePhone;
   }

   public String getWorkPhone()
   {
      return workPhone;
   }

   public String getEmail()
   {
      return email;
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
