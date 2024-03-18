class DeQue(private var tamanho: Int = 10) : DuplamenteEnfileiravel {

    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0

    override fun estaCheia(): Boolean { 
        return quantidade == dados.size
    }

    override fun estaVazia(): Boolean { 
        return quantidade == 0
    }

    override fun enfileirarInicio(dado: Any?) { 
        if (!estaCheia()) {
            ponteiroInicio--
            if (ponteiroInicio == -1)
                ponteiroInicio = dados.size -1
            if (quantidade == 0)
                ponteiroFim = dados.size -1
            quantidade++
            dados[ponteiroInicio] = dado
        } else {
            println("Queue is full!")
        }
    }

    override fun enfileirarFim(dado: Any?) { 
        if (!estaCheia()) {
            ponteiroFim++
            if (ponteiroFim == dados.size) 
                ponteiroFim = 0
            quantidade++
            dados[ponteiroFim] = dado
        } else {
            println("Queue is full!")
        }
    }

    override fun desenfileirarInicio(): Any? { 
        var aux: Any? = null
        if (!estaVazia()) {
            aux = dados[ponteiroInicio]
            ponteiroInicio++
            if (ponteiroInicio == dados.size)
                ponteiroInicio = 0
            quantidade--
        } else {
            println("Queue is empty!")
        }
        return aux //dado removido
    }

    override fun desenfileirarFim(): Any? { 
        var aux: Any? = null
        if (!estaVazia()) {
            aux = dados[ponteiroFim]
            ponteiroFim--
            if (ponteiroFim == -1)
                ponteiroFim = dados.size -1
            quantidade--
        } else {
            println("Queue is empty!")
        }
        return aux
    }

    override fun espiarFrente(): Any? { 
        var aux: Any? = null
        if (!estaVazia()) {
            aux = dados[ponteiroInicio]
        } else {
            println("Queue is empty!")
        }
        return aux //dado do início da fila
    }

    override fun espiarTras(): Any? { 
        var aux: Any? = null
        if (!estaVazia()) {
            aux = dados[ponteiroFim]
        } else {
            println("Queue is empty!")
        }
        return aux //dado do fim da fila
    }

    override fun atualizarInicio(novoDado: Any?) { 
        if (!estaVazia()) {
            dados[ponteiroInicio] = novoDado
        } else {
            println("Queue is empty!")
        }
    }

    override fun atualizarFim(novoDado: Any?) { 
        if (!estaVazia()) {
            dados[ponteiroFim] = novoDado
        } else {
            println("Queue is empty!")
        }
    }

    //Método imprimir do começo para o fim, caso seja ao contrário, deve-se alterar o for indo do último elemento ao primeiro
    override fun imprimir(): String { 
        var resultado = "["
        var aux = ponteiroInicio
        for (i in 0 .. quantidade-1) { //primeiro ao último elemento
            if (aux == dados.size) {
                aux = 0
            }
            if (i == quantidade -1) { 
                resultado += "${dados[aux]}"
            } else {
                resultado += "${dados[aux]},"
            }
            aux++
        }
        return "$resultado]"
    }
}