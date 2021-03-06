package pl.damianrowinski.flat_manager.domain.entities;

import lombok.Getter;
import lombok.Setter;
import pl.damianrowinski.flat_manager.model.common.PersonalDetails;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Transactional
@Table(name = Tenant.TABLE_NAME)
public class Tenant extends BaseEntityLoggedUser {

    final static String TABLE_NAME = "tenants";

    @Column(name = "lease_date_start", nullable = false)
    private LocalDate leaseDateStart;

    @Column(name = "lease_date_end", nullable = false)
    private LocalDate leaseDateEnd;

    @OneToOne
    private Room room;

    @Column(name = "rent_discount", nullable = true)
    private Double rentDiscount;

    @Column(name = "rent_payment_deadline", nullable = false)
    private LocalDate paymentDeadline;

    private PersonalDetails personalDetails;

    @Override
    public String toString() {
        return "Tenant{ id " + getId() +
                ", leaseDateStart=" + leaseDateStart +
                ", leaseDateEnd=" + leaseDateEnd +
                ", room=" + room +
                ", rentDiscount=" + rentDiscount +
                ", paymentDeadline=" + paymentDeadline +
                ", personalDetails=" + personalDetails +
                '}';
    }
}
