package spkrash.krashinc.mantis.model;

/**
 * Created by Krash on 12.12.2016.
 */
public class MantisUsers {
   public int id;
   public String userName;
   public String email;

   public MantisUsers(int id, String userName, String email){
      this.id = id;
      this.userName = userName;
      this.email = email;
   }

   public int getId() {
      return id;
   }

   public String getUserName() {
      return userName;
   }

   public String getEmail() {
      return email;
   }

   @Override
   public String toString() {
      return "MantisUsers{" +
            "id= " + id +
            ", userName= '" + userName + '\'' +
            ", email= '" + email + '\'' +
            '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      MantisUsers that = (MantisUsers) o;

      if (id != that.id) return false;
      if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
      return email != null ? email.equals(that.email) : that.email == null;
   }

   @Override
   public int hashCode() {
      int result = id;
      result = 31 * result + (userName != null ? userName.hashCode() : 0);
      result = 31 * result + (email != null ? email.hashCode() : 0);
      return result;
   }
}
