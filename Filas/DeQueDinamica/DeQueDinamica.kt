class DeQueDinamica(private val tamanho: Int = 10) : DeQueEnfileiravel {
    private var ponteiroInicio: DeQueNoDuplo? = null
    private var ponteiroFim: DeQueNoDuplo? = null
    private var quantidade = 0

    override fun enfileirarInicio(dado: Any?) { 
        if (!estaCheia()) {
            var noTemp = DeQueNoDuplo(dado)
            noTemp.proximo = ponteiroInicio
            if (!estaVazia()) {
                ponteiroInicio?.anterior = noTemp
            } else {
                ponteiroFim = noTemp
            }
            ponteiroInicio = noTemp
            quantidade++
        } else {
            println("Queue is full")
        }
    }

    override fun enfileirarFim(dado: Any?) { 
        if (!estaCheia()) {
            var noTemp = DeQueNoDuplo(dado)
            noTemp.anterior = ponteiroFim
            if (!estaVazia()) {
                ponteiroFim?.proximo = noTemp
            } else {
                ponteiroInicio = noTemp
            }
            ponteiroFim = noTemp
            quantidade++
        } else {
            println("Queue is full")
        }
    }

    override fun desenfileirarInicio(): Any? { 
        var aux: Any? = null
        if (!estaVazia()) {
            aux = ponteiroInicio?.dado
            ponteiroInicio = ponteiroInicio?.proximo
            quantidade--
            if (!estaVazia()) {
                ponteiroInicio?.anterior = null
            } else {
                ponteiroFim = null
            }
        } else {
            println("Queue is empty")
        }
        return aux
    }

    override fun desenfileirarFim(): Any? { 
        var aux: Any? = null
        if (!estaVazia()) {
            aux = ponteiroFim?.dado
            ponteiroFim = ponteiroFim?.anterior
            quantidade--
            if (!estaVazia()) {
                ponteiroFim?.proximo = null
            } else {
                ponteiroInicio = null
            }
        } else {
            println("Queue is empty")
        }
        return aux
    }

    override fun atualizarInicio(dado: Any?) { 
        if (!estaVazia()) {
            ponteiroInicio?.dado = dado
        } else {
            println("Queue is empty")
        }
    }

    override fun atualizarFim(dado: Any?) { 
        if (!estaVazia()) {
            ponteiroFim?.dado = dado
        } else {
            println("Queue is empty")
        }
    }

    override fun frente(): Any? { 
        var aux: Any? = null
        if (!estaVazia()) {
            aux = ponteiroInicio?.dado
        } else {
            println("Queue is empty")
        }
        return aux
    }

    override fun tras(): Any? { 
        var aux: Any? = null
        if (!estaVazia()) {
            aux = ponteiroFim?.dado
        } else {
            println("Queue is empty")
        }
        return aux
    }

    override fun estaCheia(): Boolean { 
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean { 
        return quantidade == 0
    }

    override fun imprimirFrentePraTras(): String { 
        var ponteiroAuxiliar = ponteiroInicio
        var resultado = "["
        for (i in 0 until quantidade) {
            resultado += ponteiroAuxiliar?.dado
            if (i != quantidade - 1) {
                resultado += ","
            }
            ponteiroAuxiliar = ponteiroAuxiliar?.proximo
        }
        return "$resultado]"
    }

    override fun imprimirTrasPraFrente(): String { 
        var ponteiroAuxiliar = ponteiroFim
        var resultado = "["
        for (i in 0 until quantidade) {
            resultado += ponteiroAuxiliar?.dado
            if (i != quantidade - 1) {
                resultado += ","
            }
            ponteiroAuxiliar = ponteiroAuxiliar?.anterior
        }
        return "$resultado]"
    }

}