//package mx.ipn.cic.biblioteca.AdminControl.services;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import mx.ipn.cic.biblioteca.AdminControl.model.MyUser;
//
//import java.util.Collection;
//public class MySpringUser  extends User {
//
//    private MyUser user;
//    long id;
//    public MySpringUser(Long id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
//        super(email,password, authorities);
//        this.id = id;  
//    }
//
//    public MyUser getUser() {
//        return user;
//    }
//
//    public void setUser(MyUser user) {
//        this.user = user;
//    }
//}