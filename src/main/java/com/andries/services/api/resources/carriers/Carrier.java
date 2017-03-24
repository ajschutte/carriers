package com.andries.services.api.resources.carriers;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Andries on 8/18/16.
 */
@NamedQueries({
        @NamedQuery(name="Carrier.findAll", query="SELECT c FROM Carrier c"),
})
@Entity
@Table(name = "CARRIERS")
public class Carrier {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pooled")
    @GenericGenerator(
            name = "pooled",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "CARRIER_SEQ"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "2"),
                    @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled"),
            }
    )
    @Column(name = "CARRIER_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    protected Carrier() {
    }

    public Carrier(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Carrier carrier = (Carrier) o;
        return Objects.equals(name, carrier.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name);
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Carrier{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
