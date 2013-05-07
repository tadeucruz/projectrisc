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

package br.pucminas.tadeucruz.linker;

import java.util.Vector;

public class Linker {

    private Vector<String> instrucoes = new Vector<String>();
    private String[] linha;

    public Linker() {
    }

    /**
     * Metodo resposavel por retirada de epaço e deixando no modelo ideial para tratamento
     * @param linha
     * @return
     */
    private String tratarLinha(String linha) {
        String[] tmp = linha.split(" ");
        String volta = tmp[0] + " ";
        int valor = tmp[0].length();
        char[] novaString = linha.trim().toCharArray();
        for (int i = valor; i < novaString.length; i++) {
            if (novaString[i] == ';') {
                return volta;
            } else if (novaString[i] != ' ') {
                volta = volta + novaString[i];
            }
        }
        return volta;
    }

    /**
     * Metodo responsavel por pegar linha por linha e validar 
     * @param texto - arquivo com todo texto sem esta formatado
     * @throws java.lang.Exception
     */
    public void convert(String texto) throws Exception {
        if (!texto.isEmpty()) {
            linha = texto.split("\n");
            for (int i = 0; i < linha.length; i++) {
                if (!linha[i].equals("")) {
                    validarString(linha[i]);
                }
            }
        }
    }

    /**
     * Principal metodo que pega a linha e convete para hexa
     * @param x
     * @return
     * @throws java.lang.Exception
     */
    private boolean validarString(String x) throws Exception {
        x = tratarLinha(x);
        String[] conteudo = x.split(" ");
        String bin = "";
        if (conteudo[0].contains(";")) {
            return false;
        }
        if (conteudo[0].equals("")) {
            return false;
        }
        if (conteudo[0].contains(":")) {
            return true;
        }
        if (conteudo[0].equals("add")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "11000";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
            volta = obterMemoria(regs[2]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
        } else if (conteudo[0].equals("and")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "00010";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
            volta = obterMemoria(regs[2]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
        } else if (conteudo[0].equals("asl")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "10001";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "000";
        } else if (conteudo[0].equals("asr")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "10011";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "000";
        } else if (conteudo[0].equals("deca")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "11101";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "000";
        } else if (conteudo[0].equals("inca")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "11100";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "000";
        } else if (conteudo[0].equals("load")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "10100";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "000";
        } else if (conteudo[0].equals("lsl")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "10000";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "000";
        } else if (conteudo[0].equals("lsr")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "10010";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "000";
        } else if (conteudo[0].equals("nand")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "00011";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
            volta = obterMemoria(regs[2]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
        } else if (conteudo[0].equals("nor")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "00101";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
            volta = obterMemoria(regs[2]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
        } else if (conteudo[0].equals("ones")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "00001";
            bin = bin + "000000";
        } else if (conteudo[0].equals("or")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "00100";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
            volta = obterMemoria(regs[2]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
        } else if (conteudo[0].equals("ra")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "01001";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "000";
        } else if (conteudo[0].equals("passnota")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "01000";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "000";
        } else if (conteudo[0].equals("store")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "10110";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "000";
        } else if (conteudo[0].equals("sub")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "11001";
            volta = obterMemoria(regs[1]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
            volta = obterMemoria(regs[2]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
        } else if (conteudo[0].equals("zeros")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "01";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "00000";
            bin = bin + "000000";
        } else if (conteudo[0].equals("lcl")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "11";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "100";
            if (regs[1].contains("LOWBYTE")) {
                String[] t = regs[1].split("LOWBYTE");
                regs[1] = Integer.toHexString(Integer.valueOf(t[1]));
                String t2 = String.valueOf(regs[1].charAt(0));
                t2 = t2 + String.valueOf(regs[1].charAt(1));
                regs[1] = String.valueOf(Integer.parseInt(t2, 16));
                t = null;
                t2 = null;
            } else if (regs[1].contains("HIGHBYTE")) {
                String[] t = regs[1].split("HIGHBYTEE");
                regs[1] = Integer.toHexString(Integer.valueOf(t[1]));
                String t2 = String.valueOf(regs[1].charAt(2));
                t2 = t2 + String.valueOf(regs[1].charAt(3));
                regs[1] = String.valueOf(Integer.parseInt(t2, 16));
                t = null;
                t2 = null;
            }
            bin = bin + gambiara(Integer.toBinaryString(Integer.valueOf(regs[1])));
        } else if (conteudo[0].equals("lch")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "11";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta + "000";
            if (regs[1].contains("LOWBYTE")) {
                String[] t = regs[1].split("LOWBYTE");
                regs[1] = Integer.toHexString(Integer.valueOf(t[1]));
                String t2 = String.valueOf(regs[1].charAt(0));
                t2 = t2 + String.valueOf(regs[1].charAt(1));
                regs[1] = String.valueOf(Integer.parseInt(t2, 16));
                t = null;
                t2 = null;
            } else if (regs[1].contains("HIGHBYTE")) {
                String[] t = regs[1].split("HIGHBYTE");
                regs[1] = Integer.toHexString(Integer.valueOf(t[1]));
                String t2 = String.valueOf(regs[1].charAt(2));
                t2 = t2 + String.valueOf(regs[1].charAt(3));
                regs[1] = String.valueOf(Integer.parseInt(t2, 16));
                t = null;
                t2 = null;
            }
            bin = bin + gambiara(Integer.toBinaryString(Integer.valueOf(regs[1])));
        } else if (conteudo[0].equals("j")) {
            bin = bin + "0010";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 12) {
                for (int i = pos.length(); i < 12; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("loadlit")) {
            String[] regs = conteudo[1].split(",");
            bin = bin + "10";
            String volta = obterMemoria(regs[0]);
            if (volta.equals("erro")) {
            }
            bin = bin + volta;
            bin = bin + gambiara(Integer.toBinaryString(Integer.valueOf(regs[1])));
            if (bin.length() < 16) {
                String zero = "";
                for (int i = 0; i < 16 - bin.length(); i++) {
                    zero = zero + "0";
                }
                bin = bin + zero;
            }
        } else if (conteudo[0].equals("jf.neg")) {
            bin = bin + "00000100";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("jf.zero")) {
            bin = bin + "00000101";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("jf.carry")) {
            bin = bin + "00000110";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("jf.negzero")) {
            bin = bin + "00000111";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("jf.true")) {
            bin = bin + "00000000";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("jf.overflow")) {
            bin = bin + "00000011";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("jt.neg")) {
            bin = bin + "00100100";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("jt.zero")) {
            bin = bin + "00100101";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("jt.carry")) {
            bin = bin + "00100110";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("jt.negzero")) {
            bin = bin + "00100111";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("jt.true")) {
            bin = bin + "00100010";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("jt.overflow")) {
            bin = bin + "00100011";
            String pos = acharJ(conteudo[1]);
            String a = "";
            if (pos.length() != 8) {
                for (int i = pos.length(); i < 8; i++) {
                    a = a + "0";
                }
            }
            bin = bin + a + pos;
        } else if (conteudo[0].equals("Hard")) {
            bin = bin + "11111111";
            bin = bin + gambiara(Integer.toBinaryString(Integer.valueOf(conteudo[1])));
        } else if (conteudo[0].equals(".end")) {
            return true;
        }
        //System.out.println(bin);
        if (!bin.equals("")) {
            bin = gambiaraHexa(Integer.toHexString(Integer.parseInt(bin, 2)));
            instrucoes.add(bin);
            //System.out.println("Comando: " + x + " Bin: " + bin);
            return true;
        } else {
            throw new Exception("Linha de comando: " + x + " não é correto");
        //return false;
        }

    //System.out.println(bin);

    }

    /**
     * Meotodo para achar a posição do Jumper
     * @param pulo
     * @return
     */
    private String acharJ(String pulo) {
        int count = 0;
        for (int i = 0; i < linha.length; i++) {
            if (!linha[i].equals("")) {
                if ((!(linha[i].charAt(0) == ';'))) {
                    if (linha[i].equals(pulo + ":")) {
                        //System.out.println(pulo +" "+count);
                        return Integer.toBinaryString(count);
                    }
                    if (!linha[i].equals("") && (!linha[i].contains(":"))) {
                        count++;
                    }
                }
            }

        }
        return Integer.toBinaryString(count);
    }

    /**
     * Metodo para objar o endereço da memoria
     * @param mem
     * @return
     */
    private String obterMemoria(String mem) {
        if (mem.equals("r0")) {
            return "000";
        } else if (mem.equals("r1")) {
            return "001";
        } else if (mem.equals("r2")) {
            return "010";
        } else if (mem.equals("r3")) {
            return "011";
        } else if (mem.equals("r4")) {
            return "100";
        } else if (mem.equals("r5")) {
            return "101";
        } else if (mem.equals("r6")) {
            return "110";
        } else if (mem.equals("r7")) {
            return "111";
        }
        return "erro";
    }

    /**
     * Metodo para resolver problema de 0 quando convete de hexa para bin
     * @param bin
     * @return String
     */
    private String gambiara(String bin) {
        String zero = "";
        if (bin.length() > 8) {
            zero = String.valueOf(bin.charAt(0));
            zero = zero + String.valueOf(bin.charAt(1));
            zero = zero + String.valueOf(bin.charAt(2));
            zero = zero + String.valueOf(bin.charAt(3));
            zero = zero + String.valueOf(bin.charAt(4));
            zero = zero + String.valueOf(bin.charAt(5));
            zero = zero + String.valueOf(bin.charAt(6));
            zero = zero + String.valueOf(bin.charAt(7));
            bin = "";
        } else {
            for (int i = 0; i < 8 - bin.length(); i++) {
                zero = zero + "0";
            }
        }
        return zero = zero + bin;
    }

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
     * Metodo para voltar o Vector<String> com todas intruções
     * @return  Vector<String>
     */
    public Vector<String> getInstrucoes() {
        return instrucoes;
    }
}
