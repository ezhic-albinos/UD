package com.shop.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "creator")

public class Creator
{

    @Id
    @Column(name = "artistid")
    @GeneratedValue
    private int ArtistId;
    @Column(name = "familia")
    private String Familia;
    @Column(name = "name")
    private String Name;
    @Column(name = "country")
    private String Country;
    @Column(name = "dateofbirth")
    private String DateOfBirth;
    @Column(name = "style")
    private String Style;

    @OneToMany(mappedBy = "creator",fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private List<Good> good;

    public Creator()
    {
    }

    public int getArtistId()
    {
        return ArtistId;
    }

    public void setArtistId(int artistid)
    {
        this.ArtistId = artistid;
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

    public String getCountry()
    {
        return Country;
    }

    public void setCountry(String country)
    {
        this.Country = country;
    }

    public String getDateOfBirth()
    {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateofbirth)
    {
        this.DateOfBirth = dateofbirth;
    }

    public String getStyle()
    {
        return Style;
    }

    public void setStyle(String style)
    {
        this.Style = style;
    }

    public List<Good> getGood()
    {
        return good;
    }

    public void setGood(List<Good> goods)
    {
        this.good = goods;
    }

    @Override
    public String toString()
    {
        return "Creator{" +
                "ArtistId=" + ArtistId +
                ", Familia='" + Familia + '\'' +
                ", Name='" + Name + '\'' +
                ", Country='" + Country + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", Style='" + Style + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creator creator = (Creator) o;
        return ArtistId == creator.ArtistId &&
                Familia.equals(creator.Familia) &&
                Name.equals(creator.Name) &&
                Country.equals(creator.Country) &&
                DateOfBirth.equals(creator.DateOfBirth) &&
                Style.equals(creator.Style);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(ArtistId, Familia, Name, Country, DateOfBirth, Style);
    }
}
