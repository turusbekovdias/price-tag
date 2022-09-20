package kz.datcom.pricetag.model;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String login;
    private String password;

    private String fio;
    private String phoneNumber;
    private String email;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    @OneToMany
    private List<Store> storeList;

}
