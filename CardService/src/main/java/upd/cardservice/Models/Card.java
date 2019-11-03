package upd.cardservice.Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Card")
public class Card {

    @Id
    @Column(name = "ID",unique = true,nullable = false,updatable = false)
    private String id;


}
