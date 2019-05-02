package com.example.sesi_7_rohmat_m;

public class GolonganDarah {
    private Integer id;
    private String jenis;

    public GolonganDarah(){

    }
    public GolonganDarah(Integer id, String jenis){
        this.id =id;
        this.jenis=jenis;

    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {

        this.jenis = jenis;
    }

    @Override
    public String toString(){
        return this.getJenis();
    }
}
