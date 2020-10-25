import static java.lang.Math.pow;
import static java.lang.Math.scalb;

public class TabelaVerdade {
    private int tamanhoString;

    public TabelaVerdade(String formula){
        this.tamanhoString = formula.length();
        System.out.println("\n======================================================================================");
        if (!verificaFBF(formula)){
            System.out.println("Formula mal Formada, por favor corriga e tente novamente.");
        } // if (!verificaFBF(formula))
    } // public TabelaVerdade(String fomrula)

    private char printBit(boolean x){ if (x){ return 'V'; }else{ return 'F'; } }

    private boolean testaChar(char c){
        return ('~' == c) || ('^' == c) || ('v' == c);
    } // public boolean testaChar(char c)

    private int contaVariaveis(String formula){
        int cont = 0;
        for (char c : formula.toCharArray()){
            if (!testaChar(c)){
                cont++;
            } // if (testaChar(c))
        } // for (char c : formula.toCharArray())
        return cont;
    } // private int contaVariaveis(String formula)

    private String retornaOperadores(String formula){
        String myStr = "";
        for (char c : formula.toCharArray()){
            if (('~' != c) && (testaChar(c))){
                myStr += c;
            } // if (('~' != c) && (testaChar(c)))
        } // for (char c : formula.toCharArray())
        return myStr;
    }

    private boolean executa(String formula, boolean p, boolean q){
        switch (retornaOperadores(formula)){
            case "^":
                return (p&&q);
            case "v":
                return (p||q);
        }
       return false;
    } // private boolean trocaOperador(String formula)

    private boolean executa(String formula, boolean p, boolean q, boolean r){
        switch (retornaOperadores(formula)){
            case "vv":
                return (p || q || r);
            case "^^":
                return (p && q && r);
            case "v^":
                return (p || (q && r));
            case "^v":
                return ((p && q) || r);
        } // switch (formula)
        return false;
    } // private boolean executa(String formula, boolean p, boolean q, boolean r)

    private char retorna1variavel(String formula){
        for (char i : formula.toCharArray()){
            if (!testaChar(i)){
                return i;
            } // if (testaChar(i))
        } // for (char i : formula.toCharArray())
        return ' ';
    } // private char retorna1operador(String formula)

    private char retorna2variavel(String formula){
        int cont = 0;
        for (char i : formula.toCharArray()){
            if ((!testaChar(i)) && (0 < cont)){
                return i;
            }else if (!testaChar(i)){
                cont++;
            } // if (!testaChar(i))

        } // for (char i : formula.toCharArray())
        return ' ';
    } // private char retorna2operador(String formula)

    private char retorna3variavel(String formula){
        int cont = 0;
        for (char i : formula.toCharArray()){
            if ((!testaChar(i)) && (1 < cont)){
                return i;
            }else if (!testaChar(i)){
                cont++;
            } // if (!testaChar(i))

        } // for (char i : formula.toCharArray())
        return ' ';
    }

    private  boolean verificaFBF(String formula){
        System.out.println("Formula sendo Testada: " + formula);
        switch (tamanhoString){
            case 1:
                if (!testaChar(formula.charAt(0))){
                    System.out.println("+-------+");
                    System.out.println("|   "+formula+"   |");
                    System.out.println("+-------+");
                    for (int x = 0;x < pow(2,contaVariaveis(formula));x++){
                        boolean p = true;
                        if (0 < x ){
                            p = false;
                        } // if (0 > x )
                        System.out.println("|   "+printBit(p)+"   |");
                    } // for (int x = 0;x <= contaVariaveis(formula);x++)
                    System.out.println("+-------+");
                    return true;
                }
                break;

            case 2:
                if ( ( '~' == formula.charAt(0) )  && !( testaChar(formula.charAt(1)) ) ){
                    System.out.println("+------+");
                    System.out.println("|  "+formula+"  |");
                    System.out.println("+------+");
                    for (int x = 0;x < pow(2,contaVariaveis(formula));x++){
                        boolean p = true;
                        if (0 < x ){
                            p = false;
                        } // if (0 > x )
                        System.out.println("|   "+printBit(!p)+"  |");
                    } // for (int x = 0;x <= contaVariaveis(formula);x++)
                    System.out.println("+------+");
                    return true;
                }
                break;

            case 3:
                if ( !(testaChar(formula.charAt(0))) && ( ('~' != formula.charAt(1)) && (testaChar(formula.charAt(1)))) && !(testaChar(formula.charAt(2))) ){
                    System.out.println("+-----+-----+----------+");
                    System.out.println("|  "+retorna1variavel(formula)+"  |  "+retorna2variavel(formula)+"  |    "+formula+"   |");
                    System.out.println("+-----+-----+----------+");
                    for (int x = 0;x < pow(2,contaVariaveis(formula));x++ ){
                        boolean p = true;
                        boolean q = true;
                        if (1 == (x % 2 )) {
                            q = false;
                        }
                        if(2 <= x ){
                            p = false;
                        }
                        System.out.println("|  "+printBit(p)+"  |  "+printBit(q)+"  |     "+printBit(executa(formula,p,q))+"    |");
                    } // for (int x = 0;x<=tamanhoString;x++ )
                    System.out.println("+-----+-----+----------+");
                    return true;
                }
                break;

            case 4:
                if ( ('~' == formula.charAt(0)) && !(testaChar(formula.charAt(1))) && ( ('~' != formula.charAt(2)) && (testaChar(formula.charAt(2))) ) && !(testaChar(formula.charAt(3))) ){
                    System.out.println("+-----+-----+----------+");
                    System.out.println("| ~" + retorna1variavel(formula) + "  |  " + retorna2variavel(formula) + "  |   "+formula+"   |" );
                    System.out.println("+-----+-----+----------+");
                    for (int x = 0;x < pow(2,contaVariaveis(formula)) ;x++){
                        boolean p = false;
                        boolean q = true;
                        if (1 == (x % 2)){
                            q = false;
                        }
                        if (2 <= x){
                            p = true;
                        }
                        System.out.println("|  " + printBit(p) + "  |  " + printBit(q) + "  |     " + printBit(executa(formula,p,q)) + "    |");
                    } // for (int x=0;x<=tamanhoString;x++)
                    System.out.println("+-----+-----+----------+");
                    return true;
                } else if ( !(testaChar(formula.charAt(0))) && (('~' != formula.charAt(1)) && (testaChar(formula.charAt(1)))) && ('~' == formula.charAt(2)) && !(testaChar(formula.charAt(3))) ){
                    System.out.println("+-----+-----+----------+");
                    System.out.println("|  " + retorna1variavel(formula) + "  | ~" + retorna2variavel(formula) + "  |   "+formula+"   |" );
                    System.out.println("+-----+-----+----------+");
                    for (int x = 0;x < pow(2,contaVariaveis(formula)) ;x++){
                        boolean p = true;
                        boolean q = false;
                        if (1 == (x % 2)){
                            q = true;
                        }
                        if ((pow(2,contaVariaveis(formula))/2) <= x){
                            p = false;
                        }
                        System.out.println("|  " + printBit(p) + "  |  " + printBit(q) + "  |     " + printBit(executa(formula,p,q)) + "    |");
                    } // for (int x=0;x<=tamanhoString;x++)
                    System.out.println("+-----+-----+----------+");
                    return true;
                }
                break;

            case 5:
                if ( ('~' == formula.charAt(0)) && !(testaChar(formula.charAt(1))) && (('~' != formula.charAt(2)) && (testaChar(formula.charAt(2)))) && ('~' == formula.charAt(3)) && !(testaChar(formula.charAt(4))) ){
                    System.out.println("+-----+-----+---------+");
                    System.out.println("| ~" + retorna1variavel(formula) + "  | ~" + retorna2variavel(formula) + "  |  " + formula +"  |" );
                    System.out.println("+-----+-----+---------+");
                    for (int x = 0;x < pow(2,contaVariaveis(formula));x++){
                        boolean p = false;
                        boolean q = false;
                        if (1 == (x % 2)){
                            q = true;
                        }
                        if ((pow(2,contaVariaveis(formula))/2) <= x){
                            p = true;
                        }
                        System.out.println("|  " + printBit(p) + "  |  " + printBit(q) + "  |    " + printBit(executa(formula,p,q)) + "    |");
                    } // for (int x = 0;x < pow(2,contaVariaveis(formula));x++)
                    System.out.println("+-----+-----+---------+");
                    return true;
                }else if ( !(testaChar(formula.charAt(0))) && (('~' != formula.charAt(1)) && (testaChar(formula.charAt(1)))) && !(testaChar(formula.charAt(2))) && (('~' != formula.charAt(3)) && (testaChar(formula.charAt(3)))) && !(testaChar(formula.charAt(4))) ){
                    System.out.println("+-----+-----+-----+----------+");
                    System.out.println("|  " + retorna1variavel(formula) + "  |  " + retorna2variavel(formula) +"  |  "+ retorna3variavel(formula) +"  |   " + formula +"  |" );
                    System.out.println("+-----+-----+-----+----------+");
                    boolean p = true;
                    boolean q = true;

                    for (int x = 0; x < pow(2,contaVariaveis(formula));x++){
                        boolean r = true;
                        if (1 == (x%2)){
                            r = false;
                        }
                        if ( (1 == ((x-1) % 2)) && (0 == ((x-2) % 2)) ){
                            q = !q;
                        }
                        if ((pow(2,contaVariaveis(formula))/2) <= x){
                            p = false;
                        }
                        System.out.println("|  " + printBit(p) + "  |  " + printBit(q) + "  |  " + printBit(r) + "  |     " + printBit(executa(formula,p,q,r)) + "    |");
                    } // for (int x = 0; x < pow(2,contaVariaveis(formula));x++)
                    System.out.println("+-----+-----+-----+----------+");
                    return true;
                }
                break;

            case 6:
                if ( ('~' == formula.charAt(0)) && !(testaChar(formula.charAt(1))) && (('~' != formula.charAt(2)) && (testaChar(formula.charAt(2)))) && !(testaChar(formula.charAt(3))) && (('~' != formula.charAt(4)) && (testaChar(formula.charAt(4)))) && !(testaChar(formula.charAt(5))) ){
                    System.out.println("+-----+-----+-----+----------+");
                    System.out.println("| ~" + retorna1variavel(formula) + "  |  " + retorna2variavel(formula) +"  |  "+ retorna3variavel(formula) +"  |  " + formula +"  |" );
                    System.out.println("+-----+-----+-----+----------+");
                    boolean p = false;
                    boolean q = true;

                    for (int x = 0; x < pow(2,contaVariaveis(formula));x++){
                        boolean r = true;
                        if (1 == (x%2)){
                            r = false;
                        }
                        if ( (1 == ((x-1) % 2)) && (0 == ((x-2) % 2)) ){
                            q = !q;
                        }
                        if ((pow(2,contaVariaveis(formula))/2) <= x){
                            p = true;
                        }
                        System.out.println("|  " + printBit(p) + "  |  " + printBit(q) + "  |  " + printBit(r) + "  |     " + printBit(executa(formula,p,q,r)) + "    |");
                    } // for (int x = 0; x < pow(2,contaVariaveis(formula));x++)
                    System.out.println("+-----+-----+-----+----------+");
                    return true;
                }else if ( !(testaChar(formula.charAt(0))) && (('~' != formula.charAt(1)) && (testaChar(formula.charAt(1)))) && ('~' == formula.charAt(2)) && !(testaChar(formula.charAt(3))) && (('~' != formula.charAt(4)) && (testaChar(formula.charAt(4)))) && !(testaChar(formula.charAt(5))) ){ // else if
                    System.out.println("+-----+-----+-----+----------+");
                    System.out.println("|  " + retorna1variavel(formula) + "  | ~" + retorna2variavel(formula) +"  |  "+ retorna3variavel(formula) +"  |  " + formula +"  |" );
                    System.out.println("+-----+-----+-----+----------+");
                    boolean p = true;
                    boolean q = false;

                    for (int x = 0; x < pow(2,contaVariaveis(formula));x++){
                        boolean r = true;
                        if (1 == (x%2)){
                            r = false;
                        }
                        if ( (1 == ((x-1) % 2)) && (0 == ((x-2) % 2)) ){
                            q =!q;
                        }
                        if ((pow(2,contaVariaveis(formula))/2) <= x){
                            p = false;
                        }
                        System.out.println("|  " + printBit(p) + "  |  " + printBit(q) + "  |  " + printBit(r) + "  |     " + printBit(executa(formula,p,q,r)) + "    |");
                    } // for (int x = 0; x < pow(2,contaVariaveis(formula));x++)
                    System.out.println("+-----+-----+-----+----------+");
                    return true;
                }else if( !(testaChar(formula.charAt(0))) && (('~' != formula.charAt(1)) && (testaChar(formula.charAt(1)))) && !(testaChar(formula.charAt(2))) && (('~' != formula.charAt(3)) && (testaChar(formula.charAt(3)))) && ('~' == formula.charAt(4)) && !(testaChar(formula.charAt(5))) ){
                    System.out.println("+-----+-----+-----+----------+");
                    System.out.println("|  " + retorna1variavel(formula) + "  |  " + retorna2variavel(formula) +"  | ~"+ retorna3variavel(formula) +"  |  " + formula +"  |" );
                    System.out.println("+-----+-----+-----+----------+");
                    boolean p = true;
                    boolean q = true;

                    for (int x = 0; x < pow(2,contaVariaveis(formula));x++){
                        boolean r = false ;
                        if (1 == (x%2)){
                            r = true;
                        }
                        if ( (1 == ((x-1) % 2)) && (0 == ((x-2) % 2)) ){
                            q = !q;
                        }
                        if ((pow(2,contaVariaveis(formula))/2) <= x){
                            p = false;
                        }
                        System.out.println("|  " + printBit(p) + "  |  " + printBit(q) + "  |  " + printBit(r) + "  |     " + printBit(executa(formula,p,q,r)) + "    |");
                    } // for (int x = 0; x < pow(2,contaVariaveis(formula));x++)
                    System.out.println("+-----+-----+-----+----------+");
                    return true;
                }
                break;

            case 7:
                if ( ('~' == formula.charAt(0)) && !(testaChar(formula.charAt(1))) && (('~' != formula.charAt(2)) && (testaChar(formula.charAt(2)))) && ('~' == formula.charAt(3)) && !(testaChar(formula.charAt(4))) && (('~' != formula.charAt(5)) && (testaChar(formula.charAt(5)))) && !(testaChar(formula.charAt(6))) ){
                    System.out.println("+-----+-----+-----+----------+");
                    System.out.println("| ~"+retorna1variavel(formula) + "  | ~" + retorna2variavel(formula) + "  |  " + retorna3variavel(formula) + "  | "+formula+"  |" );
                    System.out.println("+-----+-----+-----+----------+");
                    boolean p = false;
                    boolean q = false;
                    for (int x = 0; x < pow(2,contaVariaveis(formula));x++){
                        boolean r = true;
                        if (1 == (x%2)){
                            r = false;
                        }
                        if ( (1 == ((x-1)%2)) && (0 == ((x-2)%2)) ){
                            q = !q;
                        }
                        if ( (pow(2,contaVariaveis(formula))/2) <= x ){
                            p = true;
                        }
                        System.out.println("|  " + printBit(p) + "  |  " + printBit(q) + "  |  " + printBit(r) + "  |     " + printBit(executa(formula,p,q,r)) + "    |");
                    }
                    System.out.println("+-----+-----+-----+----------+");

                    return true;
                }else if ( ('~' == formula.charAt(0)) && !(testaChar(formula.charAt(1))) && (('~' != formula.charAt(2)) && (testaChar(formula.charAt(2)))) && !(testaChar(formula.charAt(3))) && (('~' != formula.charAt(4)) && (testaChar(formula.charAt(4)))) && ('~' == formula.charAt(5)) && !(testaChar(formula.charAt(6))) ){
                    System.out.println("+-----+-----+-----+----------+");
                    System.out.println("| ~" + retorna1variavel(formula) + "  |  " + retorna2variavel(formula) + "  | ~" + retorna3variavel(formula) + "  | " + formula + "  |");
                    System.out.println("+-----+-----+-----+----------+");
                    boolean p = false;
                    boolean q = true;
                    for ( int x = 0; x < pow(2,contaVariaveis(formula));x++){
                        boolean r = false;
                        if (1 == (x%2)){
                            r = true;
                        }
                        if ( (1 == ((x - 1) % 2)) && (1 == ((x - 2) % 2)) ){
                            q = !q;
                        }
                        if ( (pow(2,contaVariaveis(formula))/2) <= x ){
                            p = true;
                        }
                        System.out.println("|  " + printBit(p) + "  |  " + printBit(q) + "  |  " + printBit(r) + "  |     " + printBit(executa(formula,p,q,r)) + "    |");
                    }
                    return true;
                }else if ( !(testaChar(formula.charAt(0))) && (('~' != formula.charAt(1)) && (testaChar(formula.charAt(1)))) && ('~' == formula.charAt(2)) && !(testaChar(formula.charAt(3))) && (('~' != formula.charAt(4)) && (testaChar(formula.charAt(4)))) && ('~' == formula.charAt(5)) &&  !(testaChar(formula.charAt(6)))){
                    System.out.println("+-----+-----+-----+----------+");
                    System.out.println("|  " + retorna1variavel(formula) + "  | ~" + retorna2variavel(formula) + "  | ~" + retorna3variavel(formula) + "  | " + formula + "  |");
                    System.out.println("+-----+-----+-----+----------+");
                    boolean p = true;
                    boolean q = false;
                    for (int x = 0; x < pow(2,contaVariaveis(formula));x++){
                        boolean r = false;
                        if (1 == (x%2)){
                            r = true;
                        }
                        if ( (1 == ((x - 1) % 2)) && (1 == ((x - 2) % 2)) ){
                            q = !q;
                        }
                        if ( (pow(2,contaVariaveis(formula))) <= x ){
                            p = false;
                        }
                        System.out.println("|  " + printBit(p) + "  |  " + printBit(q) + "  |  " + printBit(r) + "  |     " + printBit(executa(formula,p,q,r)) + "    |");
                    }
                    System.out.println("+-----+-----+-----+----------+");
                    return true;
                }
                break;
            case 8:
                if ( ('~' == formula.charAt(0)) && !(testaChar(formula.charAt(1))) && (('~' != formula.charAt(2)) && (testaChar(formula.charAt(2)))) && ('~' == formula.charAt(3)) && !(testaChar(formula.charAt(4))) && (('~' != formula.charAt(5)) && (testaChar(formula.charAt(5)))) && ('~' == formula.charAt(6)) && !(testaChar(formula.charAt(7))) ){
                    System.out.println("+-----+-----+-----+----------+");
                    System.out.println("| ~" + retorna1variavel(formula) + "  | ~" + retorna2variavel(formula) + "  | ~" + retorna3variavel(formula) + "  | " + formula + "  |");
                    System.out.println("+-----+-----+-----+----------+");
                    boolean p = false;
                    boolean q = false;
                    for (int x = 0 ; x < pow(2,contaVariaveis(formula));x++){
                        boolean r = false;
                        if (1 == (x%2)){
                            r = true;
                        }
                        if ( (1 == ((x - 1) % 2)) && (1 == ((x - 2) % 2)) ){
                            q = !q;
                        }
                        if ( (pow(2,contaVariaveis(formula))/2) <= x ){
                            p = true;
                        }
                        System.out.println("|  " + printBit(p) + "  |  " + printBit(q) + "  |  " + printBit(r) + "  |     " + printBit(executa(formula,p,q,r)) + "    |");
                    }
                    System.out.println("+-----+-----+-----+----------+");
                    return true;
                }
                break;
        } // switch(tamanhoString)
        return false;
    } // public boolean verificaFBF(String)

} // public class TabelaVerdade
