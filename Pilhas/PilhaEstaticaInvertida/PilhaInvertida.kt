class PilhaInvertida : EmpilhavelInvert {
    private var ponteiroTopo: Int
    private var dados: Array<Any?>

    constructor(): this(10)

    constructor(tamanho: Int) {
        dados = arrayOfNulls(tamanho)
        ponteiroTopo = tamanho
        //o ponteiro topo, na pilha invertida, é inicializado com o tamanho da pilha, diferentemente do ponteiro topo
        //na pilha convencional, que é inicializado com -1, ou seja, quando um elemento é adicionado, o ponteiro é 
        //incrementado e indica a posição do novo elemento, já na pilha invertida, o elemento é decrementado do ponteiro topo
    }

    override fun estaCheia(): Boolean {
        return (ponteiroTopo == 0)
    }    

    override fun estaVazia(): Boolean {
        return (ponteiroTopo == dados.size)
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in ponteiroTopo .. dados.size - 1) { //os .. significa um intervalo fechado entre i e dados.size - 1
            if (i == dados.size - 1)
            resultado += "${dados[i]}"
            else
            resultado += "${dados[i]},"
        }
        return "$resultado]"
    }    

    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroTopo--
            dados[ponteiroTopo] = dado
        } else {
            println("Stack is full")  
        }
    }
   
    override fun desempilhar(): Any? {
        var retorno: Any? = null
        if (!estaVazia()) {
            retorno = dados[ponteiroTopo]
            ponteiroTopo++
        } else {
            println("Stack is empty")
        }
        return retorno
    }

    override fun topo(): Any? {
        var retorno: Any? = null
        if (!estaVazia()) {
            retorno = dados[ponteiroTopo]
        } else {
            println("Stack is empty")
        }
        return retorno
    }
}