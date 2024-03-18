class FilaCircular(val tamanho: Int = 10) : EnfileiravelCircular {
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho) 
    private var quantidade = 0

    override fun estaCheia(): Boolean { 
        return (quantidade == dados.size)
    }

    override fun estaVazia(): Boolean { 
        return (quantidade == 0)
    }

    override fun imprimir(): String {
        var resultado = "["
        var aux = ponteiroInicio
        for (i in 0 .. quantidade -1) {
            if (i == quantidade -1){
                resultado += "${dados[aux % dados.size]}"
            } else {
                resultado += "${dados[aux % dados.size]},"
            }
            aux ++
        }
        return "$resultado]"
    }    

    override fun enfileirar(dado: Any?) { 
        if (!estaCheia()) {
            ponteiroFim ++
            if (ponteiroFim == dados.size) {
                ponteiroFim = 0
            }
            quantidade ++
            dados[ponteiroFim] = dado
        } else {
            println("Queue is full!")
        }
    }

    override fun desenfileirar(): Any? {
        var dadoInicio: Any? = null
        if (!estaVazia()) {
            dadoInicio = dados[ponteiroInicio]
            ponteiroInicio ++
            if (ponteiroInicio == dados.size) {
                ponteiroInicio = 0
            }
            quantidade --
        } else {
            println("Queue is empty!")
        }
        return dadoInicio
    }

    override fun espiar(): Any? { 
        var dadoInicio: Any? = null
        if (!estaVazia()) {
            dadoInicio = dados[ponteiroInicio]
        } else {
            println("Queue is empty!")
        } 
        return dadoInicio
    }

    override fun atualizar(novoDado: Any?) { 
        if (!estaVazia()) {
            dados[ponteiroInicio] = novoDado
        } else {
            println("Queue is empty!")
        }
    }
}