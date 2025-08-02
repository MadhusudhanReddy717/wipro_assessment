package com.bookstore.model;

public class Book {
    protected int id;
    protected String t;
    protected String a;
    protected float p;

    public Book() {
    }

    public Book(String t, String a, float p) {
        this.t = t;
        this.a = a;
        this.p = p;
    }

    public Book(int id, String t, String a, float p) {
        this.id = id;
        this.t = t;
        this.a = a;
        this.p = p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return t;
    }

    public void setTitle(String t) {
        this.t = t;
    }

    public String getAuthor() {
        return a;
    }

    public void setAuthor(String a) {
        this.a = a;
    }

    public float getPrice() {
        return p;
    }

    public void setPrice(float p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", t='" + t + '\'' +
                ", a='" + a + '\'' +
                ", p=" + p +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book b = (Book) o;
        return id == b.id &&
                Float.compare(b.p, p) == 0 &&
                t.equals(b.t) &&
                a.equals(b.a);
    }

    @Override
    public int hashCode() {
        int r = id;
        r = 31 * r + t.hashCode();
        r = 31 * r + a.hashCode();
        r = 31 * r + Float.floatToIntBits(p);
        return r;
    }
}
