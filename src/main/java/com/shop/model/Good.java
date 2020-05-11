package com.shop.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "good")

public class Good
{
    @Id
    @Column(name = "goodid")
    @GeneratedValue
    private int GoodId;

    @ManyToMany
    @JoinTable(name="ordered_good",
            joinColumns=@JoinColumn(name="goodid"),
            inverseJoinColumns=@JoinColumn(name="orderid"))
    private List<Orders> orders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artistid", referencedColumnName = "artistid")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Creator creator;

    /*@Column(name = "artistid")
    private int ArtistId;*/
    @Column(name = "name")
    private String Name;
    @Column(name = "year")
    private int Year;
    @Column(name = "price")
    private int Price;
    @Column(name = "city")
    private String City;
    @Column(name = "museum_gallery")
    private String Museum_gallery;

    public Good() { }

    public Good(int goodid, String name, int year, int price, String city, String museum_gallery, Creator creator)
    {
        this.GoodId = goodid;
        this.creator = creator;
        this.Name = name;
        this.Year = year;
        this.Price = price;
        this.City = city;
        this.Museum_gallery = museum_gallery;
    }

    public int getGoodId()
    {
        return GoodId;
    }

    public void setGoodId(int goodId)
    {
        this.GoodId = goodId;
    }

    public Creator getCreator()
    {
        return creator;
    }

    public void setCreator(Creator creator)
    {
        this.creator = creator;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public int getYear()
    {
        return Year;
    }

    public void setYear(int year)
    {
        this.Year = year;
    }

    public int getPrice()
    {
        return Price;
    }

    public void setPrice(int price)
    {
        this.Price = price;
    }

    public String getCity()
    {
        return City;
    }

    public void setCity(String city)
    {
        this.City = city;
    }

    public String getMuseum_gallery()
    {
        return Museum_gallery;
    }

    public void setMuseum_gallery(String museum_gallery)
    {
        this.Museum_gallery = museum_gallery;
    }

    @Override
    public String toString()
    {
        return "Good{" +
                "GoodId=" + GoodId +
                ", ArtistId=" + creator.getFamilia() +
                ", Name='" + Name + '\'' +
                ", Year='" + Year + '\'' +
                ", Price='" + Price + '\'' +
                ", City='" + City + '\'' +
                ", Museum_gallery='" + Museum_gallery + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return GoodId == good.GoodId &&
               creator == good.creator &&
                Name.equals(good.Name) &&
                Year == good.Year &&
                Price == good.Price &&
                Museum_gallery.equals(good.Museum_gallery);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(GoodId, creator, Name, Year, Price, City, Museum_gallery);
    }
}
