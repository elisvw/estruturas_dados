/*
    Raiz = toda árvore tem raiz, mesmo sem elementos (na teoria);
    Nó sem filho = nó folha
    Ao invés de ter a refrência pro anterior/proximo, tem para o genitor
    Tipos:
    Arvore Binária de Pesquisa (ABP)
    Arvore AVL (balanceada)
    Arvore Rubo-Negra (balanceada)
    Arvore B, B+, B* (não são binárias!!!)

    OBS: tipos de impressão = pré-ordem, em ordem e pós-ordem
    Pré-ordem = raiz [esquerda] [direita]
    Em ordem = [esquerda] raiz [direita]
    Pós-ordem = [esquerda] [direita] raiz

    Exercício:
    1Q: 9 10 25 11 26 46 74 50 38 30 - conj de dados 3, impresão em pós ordem
    2Q: tirei o 4° e 7° elemento 9 10 25 26 46 50 38 30 

    Prova:
    Q1: 93, 52, 47, 31, 85, 09, 73, 83, 33, 55 - conj de dados 17
    09, 33, 31, 47, 55, 83, 73, 85, 52, 90 remover o terceiro e sétimo elemento e remover o menor à direta
*/

class ABP : Arborizavel {

    override fun inserir(dado: Any?) {
        var novoNo = NoTriplo(dado)
        if (raiz == null) {
            raiz = novoNo
        } else {
            var noAux = raiz
            while(noAux != null) {
                if (dado < noAux.dado) {
                    if (noAux.esquerdo != null) {
                        noAux = noAux.esquerdo //aponta para a esquerda dele 
                    } else {
                        noAux.esquerdo = novoNo
                        novoNo.genitor = noAux
                        break
                    }
                } else {
                    if (noAux.direito != null) {
                        noAux = noAux.direito //aponta para a direita
                    } else {
                        noAux.direito = novoNo
                        novoNo.genitor = noAux
                        break
                    }
                }
            }
        }
    }  

    override fun remover(no: NoTriplo) {
        /*remover nó sem filhos (folha)*/
        if (no.esquerdo == null && no.direito == null) {
            removeSemFilhos(no)
        } else {
            /*remover um nó que tem um único filho*/
            if (no.esquerdo == null || no.direito == null) {
                removeUnicoFilho(no)
            }
        /*remover um nó que tem dois filhos*/
        } else {
            removeDoisFilhos(no)
        }
    }

    override fun removeSemFilhos(no: NoTriplo) {
        val aux = no.genitor
        if (aux.esquerdo.dado == no.dado) {
            aux.esquerdo = null
        } else {
            aux.direito = null
        }
    }

    override fun removeUnicoFilho(no: NoTriplo) {
        val avo = no.genitor
        val neto: NoTriplo
        if (no.esquerdo == null) {
            neto = no.direito
        } else {
            neto = no.esquerdo
        }
        if (avo.esquerdo == no) {
            avo.esquerdo = neto
        } else {
            avo.direito = neto
        }
    }

    private fun imprimirPreOrdemRec(raiz: NoTriplo?): String {
        var resultado = ""
        if (raiz != null)
            resultado = "${raiz.dado} ${imprimirPreOrdemRec(raiz.esquerda)} ${imprimirPreOrdemRec(raiz.direita)}"

        return resultado
    }

    private fun imprimirEmOrdemRec(raiz: NoTriplo?): String {
        var resultado = ""     
        if (raiz != null)
            resultado = "${imprimirEmOrdemRec(raiz.esquerda)} ${raiz.dado} ${imprimirEmOrdemRec(raiz.direita)}"
        
        return resultado 
    }

    private fun imprimirPosOrdemRec(raiz: NoTriplo?): String {
        var resultado = ""       
        if (raiz != null) 
            resultado = "${imprimirPosOrdemRec(raiz.esquerda)} ${imprimirPosOrdemRec(raiz.direita)} ${raiz.dado}"

        return resultado            
    }

    override fun imprimirPreOrdem(): String {
        return imprimirPreOrdemRec(raiz)
    }

    override fun imprimirEmOrdem(): String {
        return imprimirEmOrdemRec(raiz)
    }

    override fun imprimirPosOrdem(): String {
        return imprimirPosOrdemRec(raiz)
    }
}
