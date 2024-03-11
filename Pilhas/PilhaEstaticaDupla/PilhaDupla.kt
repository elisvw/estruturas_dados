class PilhaDupla : EmpilhavelDupla {

    private var ponteiroTopo1: Int
    private var ponteiroTopo2: Int 
    private var dados: Array<Any?>
    
    constructor() : this(10) // referencia a própria classe

    constructor(tamanho: Int) {
        ponteiroTopo1 = -1
        ponteiroTopo2 = tamanho
        dados = arrayOfNulls(tamanho)
    }

    override fun empilhar1(dado: Any?) { 
        if (!estaCheia1()) {
            ponteiroTopo1++
            dados[ponteiroTopo1] = dado
        } else {
            println("Stack is full!")
        }
    }

    override fun desempilhar1(): Any? { 
        var retorno: Any? = null
        if (!estaVazia1()) {
            retorno = dados[ponteiroTopo1]
            ponteiroTopo1--
        } else {
            println("Stack is empty!")
        }
        return retorno
    }

    override fun topo1(): Any? { 
        var retorno: Any? = null
        if(!estaVazia1()) {
            retorno = dados[ponteiroTopo1]
        } else {
            println("Stack is empty!")
        }
        return retorno
    }

    override fun estaVazia1(): Boolean { 
        return (ponteiroTopo1 == -1)
    }

    override fun estaCheia1(): Boolean { 
        return (ponteiroTopo1 == ponteiroTopo2 -1)
    }

    override fun imprimir1(): String { 
        var resultado = "["
        for (i in ponteiroTopo1 downTo 0) {
            if (i == 0)
            resultado += "${dados[i]}"
            else
            resultado += "${dados[i]},"
        }
        return "$resultado]"
    }

    override fun empilhar2(dado: Any?) { 
        if (!estaCheia2()) {
            ponteiroTopo2--
            dados[ponteiroTopo2] = dado
        } else {
            println("Stack is full")
        }
    }

    override fun desempilhar2(): Any? { 
        var retorno: Any? = null
        if (!estaVazia2()) {
            retorno = dados[ponteiroTopo2]
            ponteiroTopo2++
        } else {
            println("Stack is empty")
        }
        return retorno
    }

    override fun topo2(): Any? { 
        var retorno: Any? = null
        if (!estaVazia2()) {
            retorno = dados[ponteiroTopo2]
        } else {
            println("Stack is empty")
        }
        return retorno
    }

    override fun estaVazia2(): Boolean { 
        return (ponteiroTopo2 == dados.size)
    }

    override fun estaCheia2(): Boolean { 
        return estaCheia1()
    }

    override fun imprimir2(): String { 
        var resultado = "["
        for (i in ponteiroTopo2 .. dados.size - 1) {
            if (i == dados.size - 1)
            resultado += "${dados[i]}"
            else
            resultado += "${dados[i]},"
        }
        return "$resultado]"
    }

}