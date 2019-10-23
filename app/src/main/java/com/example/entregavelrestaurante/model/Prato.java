package com.example.entregavelrestaurante.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Prato implements Parcelable {

    private String nomePrato;
    private int FotoPrato;
    private  String DetalhePrato;

    public String getDetalhePrato() {
        return DetalhePrato;
    }

    public void setDetalhePrato(String detalhePrato) {
        DetalhePrato = detalhePrato;
    }

    public Prato(String nomePrato, int fotoPrato, String detalhePrato) {
        this.nomePrato = nomePrato;
        this.FotoPrato = fotoPrato;
        this.DetalhePrato = detalhePrato;
    }

    protected Prato(Parcel in) {
        nomePrato = in.readString();
        DetalhePrato = in.readString();
        FotoPrato = in.readInt();
    }

    public static final Creator<Prato> CREATOR = new Creator<Prato>() {
        @Override
        public Prato createFromParcel(Parcel in) {
            return new Prato(in);
        }

        @Override
        public Prato[] newArray(int size) {
            return new Prato[size];
        }
    };

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public int getFotoPrato() {
        return FotoPrato;
    }

    public void setFotoPrato(int fotoPrato) {
        FotoPrato = fotoPrato;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nomePrato);
        parcel.writeString(DetalhePrato);
        parcel.writeInt(FotoPrato);
    }
}
