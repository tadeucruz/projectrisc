/*
This file is part of ProjectRisc.

ProjectRisc is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

ProjectRisc is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with ProjectRisc.  If not, see <http://www.gnu.org/licenses/>.

Copyright 2008 tadeucruz<contato@tadeucruz.com>
 */

package br.pucminas.tadeucruz.risc;

import java.util.Vector;

public class Memoria {

    private String Reg00 = "0000";
    private String Reg01 = "0000";
    private String Reg02 = "0000";
    private String Reg03 = "0000";
    private String Reg04 = "0000";
    private String Reg05 = "0000";
    private String Reg06 = "0000";
    private String Reg07 = "0000";
    private Vector<String> memoria = new Vector<String>(100);
    private String valornamemoria = "";

    public String getValornamemoria() {
        return valornamemoria;
    }

    public void setValornamemoria(String ra, String rb) {

        this.valornamemoria = valornamemoria + ra + " - " + rb + "\n";
    }

    public void limparMemoria() {
        this.valornamemoria = "";
    }

    public Vector<String> getMemoria() {
        return memoria;
    }

    public void setMemoria(int pos, String valor) {
        memoria.add(pos, valor);
    }

    public String getReg00() {
        return Reg00;
    }

    public void setReg00(String Reg00) {
        this.Reg00 = Reg00;
    }

    public String getReg01() {
        return Reg01;
    }

    public void setReg01(String Reg01) {
        this.Reg01 = Reg01;
    }

    public String getReg02() {
        return Reg02;
    }

    public void setReg02(String Reg02) {
        this.Reg02 = Reg02;
    }

    public String getReg03() {
        return Reg03;
    }

    public void setReg03(String Reg03) {
        this.Reg03 = Reg03;
    }

    public String getReg04() {
        return Reg04;
    }

    public void setReg04(String Reg04) {
        this.Reg04 = Reg04;
    }

    public String getReg05() {
        return Reg05;
    }

    public void setReg05(String Reg05) {
        this.Reg05 = Reg05;
    }

    public String getReg06() {
        return Reg06;
    }

    public void setReg06(String Reg06) {
        this.Reg06 = Reg06;
    }

    public String getReg07() {
        return Reg07;
    }

    public void setReg07(String Reg07) {
        this.Reg07 = Reg07;
    }
}
