package com.mobproj.guessnow;

public class User {
    String nama;
    String score;
    int thumbnail;

    public User(String nama, String score, int thumbnail) {
        this.nama = nama;
        score = score;
        this.thumbnail = thumbnail;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public User(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String namaMenu) {
        this.nama = namaMenu;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String hargaMenu) {
        score = hargaMenu;
    }

    public User(String nama, String score) {
        this.nama = nama;
        score = score;
    }
}
