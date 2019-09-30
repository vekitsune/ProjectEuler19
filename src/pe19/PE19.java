/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe19;

import javax.swing.JOptionPane;

/**
 *
 * @author Verosffy
 */
public class PE19 {

    /**
     * @param args the command line arguments
     */
    public static boolean vanXprimtenyezoje(int szam, int elvartPTSzam) {
        boolean vlasz = false;
        int vizsg = szam;
        int primtSzama = 1;
        int osztojelolt = 2;
        int oszto = 0;
        do {

            if (vizsg % osztojelolt == 0 && oszto != osztojelolt) {
                primtSzama++;
                oszto = osztojelolt;
                vizsg = vizsg / osztojelolt;
            } else if (vizsg % osztojelolt == 0 && oszto == osztojelolt) {
                vizsg = vizsg / osztojelolt;
            } else {
                osztojelolt++;
            }
        } while (osztojelolt != vizsg);
        if (primtSzama == elvartPTSzam) {
            vlasz = true;
        }
        return vlasz;
    }

    public static int[] tombepitoIgazSzamokbol(int szam, int elvartPTSzam) {
        int[] szamok = new int[elvartPTSzam];
        szamok[0] = szam;
        for (int i = 1; i < elvartPTSzam; i++) {
            if (vanXprimtenyezoje(++szam, elvartPTSzam)) {
                szamok[i] = szam;
            } else {

                break;

            }
        }
        return szamok;
    }

    public static int kovetzkezoXPtsSzam(int pTszam, int kezdoErtek) {
        boolean tovabb = true;
        do {
            kezdoErtek++;
            if (vanXprimtenyezoje(kezdoErtek, pTszam)) {
                tovabb = false;
            }

        } while (tovabb);

        return kezdoErtek;
    }

//            if (primtSzama == 4) {
//                vlasz = true;
//            }
//            return vlasz;
//        }
//    }
//public static 
    public static void main(String[] args) {

//        int proba = 644;
//        int elvartPT = 3;
//        System.out.println("A 644 nak 3primtenyezoje van ?" + vanXprimtenyezoje(proba, elvartPT));
//        int[] eredmeny
//                = tombepitoIgazSzamokbol(proba, elvartPT);
//        for (int i = 0; i < eredmeny.length; i++) {
//            System.out.println(eredmeny[i]);
//      
        int pTSzam = Integer.parseInt(JOptionPane.showInputDialog("hány primtényezős számokat keresel?"));
        int szam = Integer.parseInt(JOptionPane.showInputDialog("szerinted honnan kezdjek keresni?"));
        int[] valasz = new int[pTSzam];
        do {
            if (vanXprimtenyezoje(szam, pTSzam)) {
                valasz = tombepitoIgazSzamokbol(szam, pTSzam);
                
                }if (valasz[pTSzam - 1] == 0) {
                    szam = kovetzkezoXPtsSzam(pTSzam, szam);
            }

        } while (valasz[pTSzam - 1] == 0);
        String szovegesValasz="A következő számokat jónak látom: ";
        for (int i = 0; i < pTSzam; i++) {
            szovegesValasz=szovegesValasz+", "+valasz[i];
        }
        JOptionPane.showMessageDialog(null, szovegesValasz);
        System.exit(0);

    }

}
