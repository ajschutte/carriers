package com.andries.services.api.resources.carriers;

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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carrier_seq")
    @SequenceGenerator(name="carrier_seq", sequenceName = "CARRIER_SEQ", initialValue = 1, allocationSize = 3)
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
