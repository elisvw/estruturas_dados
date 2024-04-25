class ListaDinamica(var tamanho: Int = 10): ListavelDinamica {
    private var ponteiroInicio: ListaNoDuplo? = null
    private var ponteiroFim: ListaNoDuplo? = null
    private var quantidade = 0

    override fun anexar(dado: Any?) { 
        if (!estaCheia()) {
            var novoNo = ListaNoDuplo(dado)
            novoNo.anterior = ponteiroFim
            //novo nó aponta para o ponteiroFim - p/ anexar ao final
            if (!estaVazia()) {
                ponteiroFim?.proximo = novoNo
            } else {
                ponteiroInicio = novoNo
            }
            ponteiroFim = novoNo
            quantidade++
        } else {
            println("List is full!")
        }
    }

    override fun selecionarTodos(): Array<Any?> { 
        var dadosAux: Array<Any?> = arrayOfNulls(quantidade)
        //array com a mesma quantidade de elementos da lista
        if (!estaVazia()) {
            var ponteiroAux = ponteiroInicio
            for (i in 0 until quantidade) {
                dadosAux[i] = ponteiroAux?.dado
                ponteiroAux = ponteiroAux?.proximo
            }  
        } else {
            println("List is empty!")
        }
        return dadosAux
    }

    override fun selecionar(posicao: Int): Any? { 
        var dadosAux: Any? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var ponteiroAux = ponteiroInicio
                for (i in 0 until posicao) {
                    ponteiroAux = ponteiroAux?.proximo
                    // a cada iteração o ponteiro passa p/ o próx nó
                }
                dadosAux = ponteiroAux?.dado
            } else {
                println("Invalid position")
            }
        } else {
            println("List is empty!")
        }
        return dadosAux
    }

    override fun atualizar(posicao: Int, dado: Any?) { 
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var ponteiroAux = ponteiroInicio
                for (i in 0 until posicao) {
                    ponteiroAux = ponteiroAux?.proximo
                }
                ponteiroAux?.dado = dado
            } else {
                println("Invalid position")
            }
        } else {
            println("List is empty")
        }
    }

    override fun apagar(posicao: Int): Any? { 
        var dadoAux: Any? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var ponteiroAux = ponteiroInicio
                for (i in 0 until posicao) {
                    ponteiroAux = ponteiroAux?.proximo
                }
                dadoAux = ponteiroAux?.dado
                val ponteiroAnterior = ponteiroAux?.anterior
                val ponteiroProximo = ponteiroAux?.proximo
                if (ponteiroAnterior != null) {
                    ponteiroAnterior.proximo = ponteiroProximo
                    //remove do início
                } else {
                    ponteiroInicio = ponteiroInicio?.proximo
                }
                if (ponteiroProximo != null) {
                    ponteiroProximo.anterior = ponteiroAnterior
                    //remove do fim
                } else {
                    ponteiroFim = ponteiroFim?.anterior
                }
                quantidade--
            } else {
                println("Invalid position")
            }
        } else {
            println("List is empty")
        }
        return dadoAux
    }

    /*outra forma de fazer o inserir: 
        override fun inserir(posicao: Int, dado: Any?) {
            if(!estaCheia()) {
                if (posicao >= 0 && posicao <= quantidade) {
                    var ponteiroAnterior: ListaNoDuplo = null
                    var ponteiroProximo = ponteiroInicio

                    for (i in 0 until posicao) {
                        ponteiroAnterior = ponteiroProximo
                        ponteiroProximo = ponteiroProximo?.proximo
                    }

                    var novoNo = ListaNoDuplo(dado)

                    novoNo.proximo = ponteiroProximo
                    novoNo.anterior = ponteiroAnterior
                    
                    if (ponteiroAnterior != null) {
                        ponteiroAnterior.proximo = novoNo
                    } else {
                        //inserção no inicio, se for nulo
                        ponteiroInicio = novoNo
                    }
                    
                    if (ponteiroProximo != null) {
                        ponteiroProximo.anterior = novoNo
                    } else {
                        //inserção no fim, se for nulo
                        ponteiroFim = novoNo
                    }
                    quantidade++
                } else {
                    println("Indice invalido")
                }
            } else {
                println("List is full")
            }
        }
    */

    override fun inserir(posicao: Int, dado: Any?) {
        if (!estaCheia()) {
            if (posicao >= 0 && posicao <= quantidade) {
                val novoNo = ListaNoDuplo(dado)
                var ponteiroAux = ponteiroInicio
                for (i in 0 until posicao) {
                    ponteiroAux = ponteiroAux?.proximo
                }
                if (estaVazia()) {
                //novo no se torna o início e fim da lista
                    ponteiroInicio = novoNo
                    ponteiroFim = novoNo
                } else {
                    val ponteiroProximo = ponteiroAux
                    val ponteiroAnterior = ponteiroAux?.anterior ?: ponteiroFim
                    /* ?: se ponteiroAux?.anterior não for nulo, atribui ao ponteiroAnterior, 
                    caso contrário, será atribuído o ponteiroFim */
                    if (ponteiroAnterior != null) {
                        ponteiroAnterior.proximo = novoNo
                    } else {
                        ponteiroInicio = novoNo
                    }
                    if (ponteiroProximo != null) {
                        ponteiroProximo.anterior = novoNo
                    } else {
                        ponteiroFim = novoNo
                    }
                    novoNo.proximo = ponteiroProximo
                    novoNo.anterior = ponteiroAnterior
                }
                quantidade++
            } else {
                println("Invalid position")
            }
        } else {
            println("List is full")
        }
    }

    override fun estaCheia(): Boolean { 
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean { 
        return quantidade == 0
    }

    override fun imprimir(): String { 
        var ponteiroAux = ponteiroInicio
        var resultado = "["
        for (i in 0 until quantidade) {
            resultado += ponteiroAux?.dado
            if (i != quantidade - 1) {
                resultado += ","
            }
            ponteiroAux = ponteiroAux?.proximo
        }
        return "$resultado]"
    }
}