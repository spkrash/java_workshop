package spkrash.krashinc.addressbook;

public class ContactData
{
   private final String firstName;
   private final String middleName;
   private final String lastName;
   private final String nickname;
   private final String address;
   private final String mobileNum;
   private final String persEmail;

   public ContactData(String firstName, String middleName, String lastName, String nickname, String address, String mobileNum, String persEmail)
   {
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.nickname = nickname;
      this.address = address;
      this.mobileNum = mobileNum;
      this.persEmail = persEmail;
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
}
