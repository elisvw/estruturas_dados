class FilaDinamica(private val tamanho: Int = 10) : EnfileiravelDinamica {
    private var ponteiroInicio: FilaNoDuplo? = null
    private var ponteiroFim: FilaNoDuplo? = null
    private var quantidade = 0

    override fun enfileirar(dado: Any?) { 
        if (!estaCheia()) {
            var noTemp = FilaNoDuplo(dado)
            //Nó p/ amazenar o dado
            noTemp.anterior = ponteiroFim
            //Ponteiro anterior definido como o último nó
            if (!estaVazia()) {
                ponteiroFim?.proximo = noTemp
                //Próximo atualiza paara apontar p/ o novo nó
            } else {
                ponteiroInicio = noTemp
            }
            ponteiroFim = noTemp
            //Após adicionar um novo nó, o ponteiroFim aponta p/ o útltimo nó
            quantidade++
        } else {
            println("Queue is full")
        }
    }

    override fun desenfileirar(): Any? { 
        var aux: Any? = null
        if (!estaVazia()) {
            aux = ponteiroInicio?.dado
            ponteiroInicio = ponteiroInicio?.proximo
            //Ponteiro início movido p/ o próximo nó da fila, removendo o nó inicial
            quantidade--
            if (!estaVazia()) {
                ponteiroInicio?.anterior = null
                //Indica que não há nós anteriores
            } else {
                ponteiroFim = null
            }
        } else {
            println("Queue is empty")
        }
        return aux
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

    override fun atualizar(novoDado: Any?) { 
        if (!estaVazia()) {
            ponteiroInicio?.dado = novoDado
        } else {
            println("Queue is empty")
        }
    }

    override fun estaCheia(): Boolean { 
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean { 
        return quantidade == 0
    }

    override fun imprimir(): String { 
        var ponteiroAuxiliar = ponteiroInicio
        var resultado = "["
        for (i in 0 until quantidade) {
            resultado += "${ponteiroAuxiliar?.dado}"
            if (i != quantidade - 1) {
                resultado += " ,"
            }
            ponteiroAuxiliar = ponteiroAuxiliar?.proximo
        }
        return "$resultado]"
    }
}