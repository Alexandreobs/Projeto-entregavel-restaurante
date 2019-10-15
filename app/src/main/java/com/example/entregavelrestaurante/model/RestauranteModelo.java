package com.example.entregavelrestaurante.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class RestauranteModelo implements Parcelable {
    private String nomeRest;
    private String endRrest;
    private String funcionamentoRest;
    private int fotoRest;

    public RestauranteModelo(String nomeRest, String endRrest, String funcionamentoRest, int fotoRest) {
        this.nomeRest = nomeRest;
        this.endRrest = endRrest;
        this.funcionamentoRest = funcionamentoRest;
        this.fotoRest = fotoRest;
    }


    protected RestauranteModelo(Parcel in) {
        nomeRest = in.readString();
        endRrest = in.readString();
        funcionamentoRest = in.readString();
        fotoRest = in.readInt();
    }

    public String getNomeRest() {
        return nomeRest;
    }

    public void setNomeRest(String nomeRest) {
        this.nomeRest = nomeRest;
    }

    public String getEndRrest() {
        return endRrest;
    }

    public void setEndRrest(String endRrest) {
        this.endRrest = endRrest;
    }

    public String getFuncionamentoRest() {
        return funcionamentoRest;
    }

    public void setFuncionamentoRest(String funcionamentoRest) {
        this.funcionamentoRest = funcionamentoRest;
    }

    public int getFotoRest() {
        return fotoRest;
    }

    public void setFotoRest(int fotoRest) {
        this.fotoRest = fotoRest;
    }

    public static final Creator<RestauranteModelo> CREATOR = new Creator<RestauranteModelo>() {
        @Override
        public RestauranteModelo createFromParcel(Parcel in) {
            return new RestauranteModelo(in);
        }

        @Override
        public RestauranteModelo[] newArray(int size) {
            return new RestauranteModelo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nomeRest);
        parcel.writeString(endRrest);
        parcel.writeString(funcionamentoRest);
        parcel.writeInt(fotoRest);
    }
}