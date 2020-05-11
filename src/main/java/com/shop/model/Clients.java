package com.shop.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "clients")

public class Clients
{
    @Id
    @Column(name = "clientid")
    @GeneratedValue
    private int ClientId;
    @Column(name = "familia")
    private String Familia;
    @Column(name = "name")
    private String Name;
    @Column(name = "telephone")
    private String Telephone;
    @Column(name = "passport")
    private String Passport;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clients")
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private List<Orders> orders;

    public Clients() {
    }

    public int getClientId()
    {
        return ClientId;
    }

    public void setClientId(int clientId)
    {
        this.ClientId = clientId;
    }

    public String getFamilia()
    {
        return Familia;
    }

    public void setFamilia(String familia)
    {
        this.Familia = familia;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public String getTelephone()
    {
        return Telephone;
    }

    public void setTelephone(String telephone)
    {
        this.Telephone = telephone;
    }

    public String getPassport()
    {
        return Passport;
    }

    public void setPassport(String passport)
    {
        this.Passport = passport;
    }

    public List<Orders> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Orders> orders)
    {
        this.orders = orders;
    }

    @Override
    public String toString()
    {
        return "Clients{" +
                "ClientId=" + ClientId +
                ", Familia='" + Familia + '\'' +
                ", Name='" + Name + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", Passport='" + Passport + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients client = (Clients) o;
        return ClientId == client.ClientId &&
                Familia.equals(client.Familia) &&
                Name.equals(client.Name) &&
                Telephone.equals(client.Telephone) &&
                Passport.equals(client.Passport);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(ClientId, Familia, Name, Telephone, Passport);
    }
}

