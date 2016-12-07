package spkrash.krashinc.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
   @Expose
   @Column(name = "firstname")
   private String firstName;
   @Expose
   @Column(name = "middlename")
   private String middleName;
   @Expose
   @Column(name = "lastname")
   private String lastName;
   @Expose
   @Column(name = "nickname")
   private String nickname;
   @Expose
   @Column(name = "address")
   @Type(type = "text")
   private String address;
   @Expose
   @Column(name = "mobile")
   @Type(type = "text")
   private String mobilePhone;
   @Expose
   @Column(name = "home")
   @Type(type = "text")
   private String homePhone;
   @Expose
   @Column(name = "phone2")
   @Type(type = "text")
   private String homePhone2;
   @Expose
   @Column(name = "work")
   @Type(type = "text")
   private String workPhone;
   @Transient
   private String allPhones;
   @Expose
   @Column(name = "email")
   @Type(type = "text")
   private String email;
   @Expose
   @Column(name = "email2")
   @Type(type = "text")
   private String email2;
   @Expose
   @Column(name = "email3")
   @Type(type = "text")
   private String email3;
   @Transient
   private String allEmails;
   @XStreamOmitField
   @Id
   @Column(name = "id")
   private int id = Integer.MAX_VALUE;

   @Column(name = "photo")
   @Type(type = "text")
   private String photo;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "address_in_groups",
         joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
   private Set<GroupData> groups = new HashSet<GroupData>();

   public Groups getGroups() {
      return new Groups(groups);
   }

   public File getPhoto() {
      if (photo != null) {
         return new File(photo);
      } else {
         return null;
      }
   }

   public ContactData withPhoto(File photo) {
      this.photo = photo.getPath();
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
            ", middleName='" + middleName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", nickname='" + nickname + '\'' +
            ", address='" + address + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", homePhone2='" + homePhone2 + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", id=" + id +
            '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ContactData that = (ContactData) o;

      if (id != that.id) return false;
      if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
      if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
      if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
      if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
      if (address != null ? !address.equals(that.address) : that.address != null) return false;
      if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
      if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
      if (homePhone2 != null ? !homePhone2.equals(that.homePhone2) : that.homePhone2 != null) return false;
      if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
      if (email != null ? !email.equals(that.email) : that.email != null) return false;
      if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
      return email3 != null ? email3.equals(that.email3) : that.email3 == null;
   }

   @Override
   public int hashCode() {
      int result = firstName != null ? firstName.hashCode() : 0;
      result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
      result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
      result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
      result = 31 * result + (address != null ? address.hashCode() : 0);
      result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
      result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
      result = 31 * result + (homePhone2 != null ? homePhone2.hashCode() : 0);
      result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
      result = 31 * result + (email != null ? email.hashCode() : 0);
      result = 31 * result + (email2 != null ? email2.hashCode() : 0);
      result = 31 * result + (email3 != null ? email3.hashCode() : 0);
      result = 31 * result + id;
      return result;
   }

   public ContactData inGroup(GroupData group) {
      groups.add(group);
      return this;
   }
}
