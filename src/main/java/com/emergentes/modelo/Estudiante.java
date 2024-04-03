package com.emergentes.modelo;
public class Estudiante {
   private int id;
   private String Nombre_del_estudiante;
   private int Primer_Parcial;
   private int Segundo_Parcial;
   private int Examen_Final;
   private int Nota;
   
   public Estudiante(){
       this.id=0;
       this.Nombre_del_estudiante="";
       this.Primer_Parcial=0;
       this.Segundo_Parcial=0;
       this.Examen_Final=0;
       this.Nota=0;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_del_estudiante() {
        return Nombre_del_estudiante;
    }

    public void setNombre_del_estudiante(String Nombre_del_estudiante) {
        this.Nombre_del_estudiante = Nombre_del_estudiante;
    }

    public int getPrimer_Parcial() {
        return Primer_Parcial;
    }

    public void setPrimer_Parcial(int Primer_Parcial) {
        this.Primer_Parcial = Primer_Parcial;
    }

    public int getSegundo_Parcial() {
        return Segundo_Parcial;
    }

    public void setSegundo_Parcial(int Segundo_Parcial) {
        this.Segundo_Parcial = Segundo_Parcial;
    }

    public int getExamen_Final() {
        return Examen_Final;
    }

    public void setExamen_Final(int Examen_Final) {
        this.Examen_Final = Examen_Final;
    }

    public int getNota() {
        return Nota;
    }

    public void setNota(int Nota) {
        this.Nota = Nota;
    }

}