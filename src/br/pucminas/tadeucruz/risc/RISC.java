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

public class RISC {

    private Memoria memoria = new Memoria();
    private Flags flags = new Flags();
    public int jumpRC = -1;

    /**
     * Contrutor
     */
    public RISC() {
    }

    public Flags getFlags() {
        return flags;
    }

    /**
     * Metodo que inicia a execução do Risc
     * @param ins Strig com a intrução a ser executada
     */
    public void IF(String ins) throws Exception {
        ID(ins);
    }

    /**
     * Memtodo que pega do hexa e convete para bin
     * @param ins Strig com a intrução a ser executada
     */
    private void ID(String ins) throws Exception {
        String bin = Integer.toBinaryString(Integer.parseInt(ins, 16));
        bin = gambiara(bin);
        char[] decodificada = bin.toCharArray();
        String opcode = String.valueOf(decodificada[0]) + String.valueOf(decodificada[1]);
        if (opcode.equals("01")) {
            //System.out.println11(String.valueOf(decodificada[3]) + String.valueOf(decodificada[4]) + String.valueOf(decodificada[5]));
            String rc = String.valueOf(decodificada[2]) + String.valueOf(decodificada[3]) + String.valueOf(decodificada[4]);
            String OP = String.valueOf(decodificada[5]) + String.valueOf(decodificada[6]) + String.valueOf(decodificada[7]) + String.valueOf(decodificada[8]) + String.valueOf(decodificada[9]);
            String ra = obterMemoria(String.valueOf(decodificada[10]) + String.valueOf(decodificada[11]) + String.valueOf(decodificada[12]));
            String rb = obterMemoria(String.valueOf(decodificada[13]) + String.valueOf(decodificada[14]) + String.valueOf(decodificada[15]));
            EXWB(OP, rc, ra, rb);
        }
        if (opcode.equals("11")) {
            if ((opcode + String.valueOf(decodificada[2]) + String.valueOf(decodificada[3]) + String.valueOf(decodificada[4]) + String.valueOf(decodificada[5]) + String.valueOf(decodificada[6]) + String.valueOf(decodificada[7])).equals("11111111")) {
                String ra = String.valueOf(decodificada[8]) + String.valueOf(decodificada[9]) + String.valueOf(decodificada[10]) + String.valueOf(decodificada[11]) + String.valueOf(decodificada[12]) + String.valueOf(decodificada[13]) + String.valueOf(decodificada[14]) + String.valueOf(decodificada[15]);
                throw new Exception("Não foi possivel implementar a porta logica, unica solução para Windows disponivel, porem o sinal ia ser enviado para a porta: " + Integer.valueOf(Integer.parseInt(ra, 2)));
            } else {
                String rc = String.valueOf(decodificada[2]) + String.valueOf(decodificada[3]) + String.valueOf(decodificada[4]);
                String OP = String.valueOf(decodificada[5]);
                String ra = String.valueOf(decodificada[8]) + String.valueOf(decodificada[9]) + String.valueOf(decodificada[10]) + String.valueOf(decodificada[11]) + String.valueOf(decodificada[12]) + String.valueOf(decodificada[13]) + String.valueOf(decodificada[14]) + String.valueOf(decodificada[15]);
                String rb = "";
                EXWB(OP, rc, ra, rb);
            }
        }
        if (opcode.equals("00")) {
            String rc = "";
            String OP = String.valueOf(decodificada[2]) + String.valueOf(decodificada[3]);
            String ra = String.valueOf(decodificada[4]) + String.valueOf(decodificada[5]) + String.valueOf(decodificada[6]) + String.valueOf(decodificada[7]) + String.valueOf(decodificada[8]) + String.valueOf(decodificada[9]) + String.valueOf(decodificada[10]) + String.valueOf(decodificada[11]) + String.valueOf(decodificada[12]) + String.valueOf(decodificada[13]) + String.valueOf(decodificada[14]) + String.valueOf(decodificada[15]);
            String rb = "";
            EXWB(OP, rc, ra, rb);
        }
        if (opcode.equals("10")) {
            String rc = String.valueOf(decodificada[2]) + String.valueOf(decodificada[3]) + String.valueOf(decodificada[4]);
            String OP = String.valueOf(decodificada[0]) + String.valueOf(decodificada[1]);
            String ra = String.valueOf(decodificada[5]) + String.valueOf(decodificada[6]) + String.valueOf(decodificada[7]) + String.valueOf(decodificada[8]) + String.valueOf(decodificada[9]) + String.valueOf(decodificada[10]) + String.valueOf(decodificada[11]) + String.valueOf(decodificada[12]) + String.valueOf(decodificada[13]) + String.valueOf(decodificada[14]);
            String rb = "";
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(Integer.parseInt(ra, 2))));
        }
    }

    /**
     * Metodo que realmente executa a instrução
     * @param OP Operador
     * @param rc RC
     * @param ra RA
     * @param rb RB
     */
    private void EXWB(String OP, String rc, String ra, String rb) {
        //soma direta
        if (OP.equals("11000")) {
            int v1 = Integer.parseInt(ra, 16);
            int v2 = Integer.parseInt(rb, 16);
            v1 = v1 + v2;
            if (v1 >= 65536) {
                v1 = 0;
                flags.setOverflow(1);
                flags.setCarry(1);
            } else {
                flags.setOverflow(0);
                flags.setCarry(0);
            }
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(v1)));
        } else if (OP.equals("00010")) { // Efetua and lógico bit a bit de ra e rb e coloca resultado em rc.

            int bit1 = Integer.parseInt(ra, 16);
            int bit2 = Integer.parseInt(rb, 16);
            bit1 = bit1 & bit2;
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("10001")) { //Coloca cada bit rai em rci+1 e preenche com 0 a posição rc0.

            int bit1 = Integer.parseInt(ra, 16);
            //int bit2 = Integer.valueOf(Integer.toBinaryString(Integer.parseInt(obterMemoria(rc),16)));
            bit1 = bit1 << 1;
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("10011")) { //Coloca cada bit rai em rci-1 (exceto ra0) e preenche com ra15 a posição rc15.

            int bit1 = Integer.parseInt(ra, 16);
            //int bit2 = Integer.valueOf(Integer.toHexString(Integer.parseInt(obterMemoria(rc),16)));
            //System.out.println(bit1);
            //System.out.println(bit2);
            bit1 = bit1 >> 1;
            setarMemoria(rc, gambiaraHexa(Long.toHexString(bit1)));
        } else if (OP.equals("11101")) { // Subtrai 1 do conteúdo de ra e coloca o resultado em rc.

            int bit1 = Integer.parseInt(ra, 16);
            bit1--;
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("11100")) { // Adiciona 1 ao conteúdo de ra e coloca o resultado em rc.

            int bit1 = Integer.parseInt(ra, 16);
            bit1++;
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("10100")) { //Carrega no registrador c o conteúdo da memória endereçada pelo registrador a.

            int bit1 = Integer.parseInt(ra, 16);
            String val = memoria.getMemoria().get(bit1);
            bit1 = Integer.valueOf(val);
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("10000")) { //Coloca cada bit rai em rci+1 (exceto ra15) e preenche com 0 a posição rc0.

            int bit1 = Integer.parseInt(ra, 16);
            bit1 = bit1 << 1;
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("10010")) { //Coloca cada bit rai em rci-1 (exceto ra0) e preenche com 0 a posição rc15.

            int bit1 = Integer.parseInt(ra, 16);
            bit1 = bit1 >> 1;
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("00011")) { // Efetua nand lógico bit a bit de ra e rb e coloca resultado em rc.

            int bit1 = Integer.parseInt(ra, 16);
            int bit2 = Integer.parseInt(rb, 16);
            bit1 = Integer.reverseBytes(bit1) | Integer.reverseBytes(bit2);
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("00101")) { //Efetua nor lógico bit a bit de ra e rb e coloca resultado em rc.

            int bit1 = Integer.parseInt(ra, 16);
            int bit2 = Integer.parseInt(rb, 16);
            bit1 = Integer.reverseBytes(bit1) & Integer.reverseBytes(bit2);
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("00100")) { //Efetua or lógico bit a bit de ra e rb e coloca resultado em rc.

            int bit1 = Integer.parseInt(ra, 16);
            int bit2 = Integer.parseInt(rb, 16);
            bit1 = bit1 | bit2;
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("01001")) { //Faz conteúdo de rc igual ao conteúdo de ra.

            int bit1 = Integer.parseInt(ra, 16);
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("01001")) { //Faz conteúdo de rc valer o complemento do conteúdo de ra.

            int bit1 = Integer.parseInt(ra, 16);
            bit1 = Integer.reverseBytes(bit1);
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(bit1)));
        } else if (OP.equals("01001")) { //carrega na posição da memória endereçada pelo registrador a o conteúdo do registrador b.

            rc = obterMemoria(rc);
            int pos = Integer.parseInt(rc, 16);
            memoria.setMemoria(pos, ra);
        } else if (OP.equals("10110")) {//carrega na posição da memória endereçada pelo registrador a o conteúdo do registrador b. 
            String c = obterMemoria(rc);
            int a = Integer.parseInt(c, 16);
            memoria.setValornamemoria(Integer.toString(a), ra);
        } else if (OP.equals("11001")) { //Subtrai o conteúdo de rb do conteúdo de ra e coloca o resultado em rc.

            int v1 = Integer.parseInt(ra, 16);
            int v2 = Integer.parseInt(rb, 16);
            v1 = v1 - v2;
            if (v1 < 0) {
                flags.setNeg(1);
                flags.setZero(0);
                flags.setNegZero(1);

            } else if (v1 == 0) {
                flags.setZero(1);
                flags.setNegZero(1);
            } else {
                flags.setNeg(0);
                flags.setZero(0);
                flags.setNegZero(0);
                flags.setOverflow(1);
            }
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(v1)));
        } else if (OP.equals("0000")) {
            int v1 = 0;
            setarMemoria(rc, gambiaraHexa(Integer.toHexString(v1)));
        }
        if (OP.equals("1") || OP.equals("0")) {
            String memoria = obterMemoria(rc);
            char[] conteudoMemoria = memoria.toCharArray();
            if (OP.equals("1")) {
                String t = Integer.toHexString(Integer.parseInt(ra, 2));
                conteudoMemoria[0] = t.charAt(0);
                conteudoMemoria[1] = t.charAt(1);
                setarMemoria(rc, String.valueOf(conteudoMemoria));
            //ra = Integer.toBinaryString(Integer.valueOf(String.valueOf(conteudoMemoria)));
            } else if (OP.equals("0")) {
                String t = Integer.toHexString(Integer.parseInt(ra, 2));
                if (t.length() == 1) {
                    return;
                }
                conteudoMemoria[2] = t.charAt(0);
                conteudoMemoria[3] = t.charAt(1);
                setarMemoria(rc, String.valueOf(conteudoMemoria));
            //ra = Integer.toBinaryString(Integer.valueOf(String.valueOf(conteudoMemoria)));
            }
        //setarMemoria(rc, gambiaraHexa(Integer.toHexString(Integer.parseInt(ra, 2))));
        }

        if (OP.equals("00")) { // revisar
            String cond = String.valueOf(ra.charAt(0)) + String.valueOf(ra.charAt(1)) + String.valueOf(ra.charAt(2)) + String.valueOf(ra.charAt(3));
            String t = String.valueOf(ra.charAt(4)) + String.valueOf(ra.charAt(5)) + String.valueOf(ra.charAt(6)) + String.valueOf(ra.charAt(7)) + String.valueOf(ra.charAt(8)) + String.valueOf(ra.charAt(9)) + String.valueOf(ra.charAt(10)) + String.valueOf(ra.charAt(11));
            if (cond.equals("0100")) {
                if (!(flags.getNeg() == 1)) {
                    jumpRC = Integer.parseInt(t, 2);
                }
            } else if (cond.equals("0101")) {
                if (!(flags.getZero() == 1)) {
                    jumpRC = Integer.parseInt(t, 2);
                }
            } else if (cond.equals("0110")) {
                if (!(flags.getCarry() == 1)) {
                    jumpRC = Integer.parseInt(t, 2);
                }
            } else if (cond.equals("0111")) {
                if (!(flags.getNegZero() == 1)) {
                    jumpRC = Integer.parseInt(t, 2);
                }
            } else if (cond.equals("0000")) {
                jumpRC = Integer.parseInt(t, 2);
            } else if (cond.equals("0011")) {
                if (!(flags.getOverflow() == 1)) {
                    jumpRC = Integer.parseInt(t, 2);
                }
            }
        }

        if (OP.equals("10")) { // revisar
            String cond = String.valueOf(ra.charAt(0)) + String.valueOf(ra.charAt(1)) + String.valueOf(ra.charAt(2)) + String.valueOf(ra.charAt(3));
            String t = String.valueOf(ra.charAt(4)) + String.valueOf(ra.charAt(5)) + String.valueOf(ra.charAt(6)) + String.valueOf(ra.charAt(7)) + String.valueOf(ra.charAt(8)) + String.valueOf(ra.charAt(9)) + String.valueOf(ra.charAt(10)) + String.valueOf(ra.charAt(11));
            if (cond.equals("0100")) {
                if ((flags.getNeg() == 1)) {
                    jumpRC = Integer.parseInt(t, 2);
                }
            } else if (cond.equals("0101")) {
                if ((flags.getZero() == 1)) {
                    jumpRC = Integer.parseInt(t, 2);
                }
            } else if (cond.equals("0110")) {
                if ((flags.getCarry() == 1)) {
                    jumpRC = Integer.parseInt(t, 2);
                }
            } else if (cond.equals("0111")) {
                if ((flags.getNegZero() == 1)) {
                    jumpRC = Integer.parseInt(t, 2);
                }
            } else if (cond.equals("0000")) {
                jumpRC = Integer.parseInt(t, 2);
            } else if (cond.equals("0011")) {
                if ((flags.getOverflow() == 1)) {
                    jumpRC = Integer.parseInt(t, 2);
                }
            } else {
                jumpRC = Integer.parseInt(ra, 2);
            }
        }

    }

    /**
     * Obter o conteudo dos registradores
     * @param idmemoria endereço da memoria
     * @return
     */
    private String obterMemoria(String idmemoria) {
        if (idmemoria.equals("000")) {
            return memoria.getReg00();
        } else if (idmemoria.equals("001")) {
            return memoria.getReg01();
        } else if (idmemoria.equals("010")) {
            return memoria.getReg02();
        } else if (idmemoria.equals("011")) {
            return memoria.getReg03();
        } else if (idmemoria.equals("100")) {
            return memoria.getReg04();
        } else if (idmemoria.equals("101")) {
            return memoria.getReg05();
        } else if (idmemoria.equals("110")) {
            return memoria.getReg06();
        } else if (idmemoria.equals("111")) {
            return memoria.getReg07();
        }
        return "erro";
    }

    /**
     * Metodo para setar valor nos registradores
     * @param idmemoria 
     * @param valor
     */
    private void setarMemoria(String idmemoria, String valor) {
        if (idmemoria.equals("000")) {
            memoria.setReg00(valor);
        } else if (idmemoria.equals("001")) {
            memoria.setReg01(valor);
        } else if (idmemoria.equals("010")) {
            memoria.setReg02(valor);
        } else if (idmemoria.equals("011")) {
            memoria.setReg03(valor);
        } else if (idmemoria.equals("100")) {
            memoria.setReg04(valor);
        } else if (idmemoria.equals("101")) {
            memoria.setReg05(valor);
        } else if (idmemoria.equals("110")) {
            memoria.setReg06(valor);
        } else if (idmemoria.equals("111")) {
            memoria.setReg07(valor);
        }
    }

    /**
     * Meotodo de ajuda
     * @param bin
     * @return
     */
    public String gambiara(String bin) {
        if (bin.length() == 16) {
            return bin;
        }
        String zero = "";
        for (int i = 0; i < 16 - bin.length(); i++) {
            zero = zero + "0";
        }
        return zero = zero + bin;
    }

    /**
     * Metodo de ajuda
     * @param hexa
     * @return
     */
    private String gambiaraHexa(String hexa) {
        String zero = "";
        for (int i = 0; i < 4 - hexa.length(); i++) {
            zero = zero + "0";
        }
        zero = zero + hexa;
        if (hexa.length() > 4) {
            zero = "ffff";
        }
        return zero;
    }

    /**
     * Metodo que retorna o conteudo da memoria
     * @return
     */
    public Memoria getMemoria() {
        return memoria;
    }

    /**
     * Meotodo para setar a memoria
     */
    public void setMemoria() {
        this.memoria = memoria;
    }
}
