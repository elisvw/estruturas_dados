class PilhaDinamica(var tamanho: Int = 10): EmpilhavelDinamica {
// Na pilha dinâmica, tamanho funciona como um tam máximo 

    private var ponteiroTopo: NoDuplo? = null // Como não tem array, a var é do tipo do objeto (NoDuplo)
    private var quantidade = 0

    override fun empilhar(dado: Any?) { 
        if (!estaCheia()) {
            var novoNo = NoDuplo(dado)
            novoNo.anterior = ponteiroTopo
            if (!estaVazia()) {
                ponteiroTopo?.proximo = novoNo
            }
            ponteiroTopo = novoNo
            quantidade++
        } else {
            println("Stack is full")
        }
    }

    override fun desempilhar(): Any? { 
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = ponteiroTopo?.dado
            // P/ voltar ao dado anterior:
            ponteiroTopo = ponteiroTopo?.anterior
            if (ponteiroTopo != null) {
                ponteiroTopo?.proximo = null
            }
            quantidade--
        } else {
            println("Stack is empty")
        }
        return dadoTopo
    }

    override fun espiar(): Any? { 
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = ponteiroTopo?.dado
        } else {
            println("Stack is empty")
        }
        return dadoTopo
    }

    override fun atualizar(novoDado: Any?) { 
        if (!estaVazia()) {
            ponteiroTopo?.dado = novoDado 
        } else {
            println("Stack is empty")
        }
    }

    override fun estaVazia(): Boolean { 
        return quantidade == 0
    }

    override fun estaCheia(): Boolean { 
        return quantidade == tamanho // P/ não permitir a inserção de novos elementos na pilha
    }

    override fun imprimir(): String { 
        var ponteiroAux = ponteiroTopo
        var resultado = "["
        for (i in 0 until quantidade) {
            resultado += ponteiroAux?.dado
            if (i != quantidade - 1) 
                resultado += ", "
            ponteiroAux = ponteiroAux?.anterior
        }
        return "$resultado]"
    }

}